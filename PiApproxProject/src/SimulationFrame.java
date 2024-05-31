import javax.swing.*;

public class SimulationFrame extends JFrame {

    public SimulationFrame()
    {
        setTitle("Symulacja");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        int initMass = ValidatedInitialMass();
        SimulationPanel simulationPanel = new SimulationPanel(initMass);
        add(simulationPanel);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private int ValidatedInitialMass()
    {
        int initMass;
        while(true) {

            String initMassString = JOptionPane.showInputDialog(this, "Podaj wartość początkową:", "Wartość początkowa", JOptionPane.PLAIN_MESSAGE);

            try {
                initMass = Integer.parseInt(initMassString);
                if (initMass > 0) {
                    break;
                } else {
                    JOptionPane.showMessageDialog(this, "Wprowadź liczbę całkowitą większą od 0.", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Wprowadź poprawną liczbę całkowitą większą od 0.", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        }
        return initMass;
    }
}
