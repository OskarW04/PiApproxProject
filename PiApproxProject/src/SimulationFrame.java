import javax.swing.*;

public class SimulationFrame extends JFrame {
    private SimulationPanel simulationPanel;

    public SimulationFrame()
    {
        setTitle("Symulacja");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        simulationPanel = new SimulationPanel();
        add(simulationPanel);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
