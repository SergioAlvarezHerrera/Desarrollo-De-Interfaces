package panels;

import cineapp.*;
import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.stream.Collectors;

public class GraficosPanel extends JPanel {
    private PeliculaManager manager;

    public GraficosPanel(PeliculaManager manager) {
        this.manager = manager;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Map<String, Long> conteoTipos = manager.getPeliculas().stream()
                .collect(Collectors.groupingBy(Pelicula::getTipo, Collectors.counting()));

        int width = getWidth();
        int height = getHeight();
        int barWidth = width / conteoTipos.size();
        int maxHeight = height - 50;

        int maxCount = conteoTipos.values().stream().mapToInt(Long::intValue).max().orElse(1);

        int x = 0;
        for (Map.Entry<String, Long> entry : conteoTipos.entrySet()) {
            int barHeight = (int) ((entry.getValue() * 1.0 / maxCount) * maxHeight);

            g.setColor(Color.BLUE);
            g.fillRect(x, height - barHeight - 20, barWidth - 10, barHeight);

            g.setColor(Color.BLACK);
            g.drawString(entry.getKey(), x + 10, height - 10);
            g.drawString(String.valueOf(entry.getValue()), x + 10, height - barHeight - 30);

            x += barWidth;
        }
    }
}
