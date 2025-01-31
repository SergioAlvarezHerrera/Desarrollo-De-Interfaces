package notas;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.CannotRedoException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

class NotesApp extends JFrame {
    private JList<String> notesList;
    private DefaultListModel<String> notesModel;
    private JTextArea noteTextArea;
    private UndoManager undoManager;

    public NotesApp() {
        setTitle("Notas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        notesModel = new DefaultListModel<>();
        notesList = new JList<>(notesModel);
        noteTextArea = new JTextArea();
        noteTextArea.setLineWrap(true);
        noteTextArea.setWrapStyleWord(true);

        loadNotesFromFile();

        undoManager = new UndoManager();
        noteTextArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });

        Action undoAction = new AbstractAction("atras") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (undoManager.canUndo()) {
                        undoManager.undo();
                    }
                } catch (CannotUndoException ex) {
                    ex.printStackTrace();
                }
            }
        };

        Action redoAction = new AbstractAction("alante") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (undoManager.canRedo()) {
                        undoManager.redo();
                    }
                } catch (CannotRedoException ex) {
                    ex.printStackTrace();
                }
            }
        };

        noteTextArea.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "Undo");
        noteTextArea.getActionMap().put("Undo", undoAction);
        noteTextArea.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_Y, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()), "Redo");
        noteTextArea.getActionMap().put("Redo", redoAction);

        JButton addButton = new JButton("Añadir Nota");
        addButton.setToolTipText("Añadir una nueva nota");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String noteName = JOptionPane.showInputDialog(NotesApp.this, "Ingrese el nombre de la nota:");
                if (noteName != null && !noteName.trim().isEmpty()) {
                    notesModel.addElement(noteName);
                    noteTextArea.setText("");
                    saveNotesToFile();
                }
            }
        });

        JButton saveButton = new JButton("Guardar Nota");
        saveButton.setToolTipText("Guardar la nota actual");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = notesList.getSelectedIndex();
                if (index != -1) {
                    String noteContent = noteTextArea.getText();
                    notesModel.set(index, notesModel.getElementAt(index).split(":")[0] + ":" + noteContent);
                    saveNotesToFile();
                }
            }
        });

        JButton deleteButton = new JButton("Eliminar Nota");
        deleteButton.setToolTipText("Eliminar la nota seleccionada");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = notesList.getSelectedIndex();
                if (index != -1) {
                    notesModel.remove(index);
                    noteTextArea.setText("");
                    saveNotesToFile();
                }
            }
        });

        noteTextArea.setToolTipText("Escriba el contenido de su nota aquí");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(deleteButton);

        notesList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int index = notesList.getSelectedIndex();
                if (index != -1) {
                    String[] noteData = notesModel.getElementAt(index).split(":", 2);
                    noteTextArea.setText(noteData.length > 1 ? noteData[1] : "");
                }
            }
        });

        LookAndFeelExample lookAndFeelExample = new LookAndFeelExample();
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Selecciona Look & Feel:"));
        topPanel.add(lookAndFeelExample);

        JScrollPane scrol = new JScrollPane(notesList);
        scrol.setPreferredSize(new Dimension(200, 0));
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(scrol, BorderLayout.WEST);
        add(new JScrollPane(noteTextArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    private void saveNotesToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("notas.txt"))) {
            for (int i = 0; i < notesModel.getSize(); i++) {
                writer.println(notesModel.getElementAt(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadNotesFromFile() {
        File file = new File("notas.txt");
        if (!file.exists()) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                notesModel.addElement(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        NotesApp nota = new NotesApp();
    }
}

