import javax.swing.*;

public class SimulationFrame extends JFrame {

    public SimulationFrame()
    {
        setTitle("Symulacja");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        SimulationPanel simulationPanel = new SimulationPanel();
        add(simulationPanel);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
