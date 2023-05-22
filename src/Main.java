import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.ArrayList;


public class Main {
    private static JTextField sum, avg, max, min;

    private static ArrayList<Double> arr = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                JFrame frame = getFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void mathStat() {
        double mSum = 0, mMin = arr.get(0), mMax = arr.get(0);
        StringBuilder arrS = new StringBuilder();

        if (arr.size() == 0) return;

        for (double a : arr) {
            arrS.append(a);
            mSum += a;

            if (a < mMin) {
                mMin = a;
            }

            if (a > mMax) {
                mMax = a;
            }

        }
        sum.setText(String.valueOf(mSum));
        max.setText(String.valueOf(mMax));
        min.setText(String.valueOf(mMin));
        avg.setText(String.valueOf(mSum / arr.size()));
        sum.setCaretPosition(0);
        max.setCaretPosition(0);
        min.setCaretPosition(0);
        avg.setCaretPosition(0);

        arr.clear();
    }

    static JFrame getFrame() {
        JButton resultButton, exitButton;
        JScrollPane scrollPane;
        JFrame jFrame = new JFrame() {
        };
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        jFrame.setBounds(dimension.width / 2 - 200, dimension.height / 2 - 250, 400, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("ArrayWithOutEclipse");
        jFrame.setResizable(false);
//        JLayeredPane layeredPane = new JLayeredPane();
//        layeredPane.setLayout(null);
//        jFrame.add(layeredPane);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "\u0420\u0435\u0437\u0443\u043B\u044C\u0442\u0430\u0442", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(10, 220, 360, 200);
        panel.setLayout(null);
        panel.setVisible(true);
        contentPane.add(panel);

        JLabel textMax = new JLabel("Max");
        textMax.setBounds(10, 50, 50, 50);
        panel.add(textMax);

        JLabel textSum = new JLabel("Sum");
        textSum.setBounds(10, 120, 50, 50);
        panel.add(textSum);

        JLabel textMin = new JLabel("Min");
        textMin.setBounds(220, 50, 50, 50);
        panel.add(textMin);

        JLabel textAverage = new JLabel("Average");
        textAverage.setBounds(220, 120, 50, 50);
        panel.add(textAverage);

        max = new JTextField();
        max.setBounds(55, 60, 90, 30);
        max.setColumns(10);
        panel.add(max);

        min = new JTextField();
        min.setBounds(255, 60, 90, 30);
        min.setColumns(10);
        panel.add(min);

        sum = new JTextField();
        sum.setBounds(55, 130, 90, 30);
        sum.setColumns(10);
        panel.add(sum);

        avg = new JTextField();
        avg.setBounds(270, 130, 75, 30);
        avg.setColumns(10);
        panel.add(avg);


        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(10, 30, 360, 180);
        contentPane.add(scrollPane);

        JTextArea areaText = new JTextArea();
        scrollPane.setViewportView(areaText);

        resultButton = new JButton("Расчёт");
        resultButton.setBounds(10, 425, 100, 30);
        resultButton.addActionListener((e) -> {
            String[] stringArray = areaText.getText().replace('\n', ' ').replace(',', '.').split(" ");
            for (String numberString : stringArray) {
                Double number = null;
                try {
                    number = Double.parseDouble(numberString);
                } catch (NumberFormatException e1) {
                    continue;
                }

                arr.add(number);
            }

            mathStat();
        });
        contentPane.add(resultButton);

//        ImageIcon img = new ImageIcon("picture/4322908.jpg");
//        JLabel backGround = new JLabel("", img, JLabel.CENTER);
//        backGround.setBounds(0, 0, 400, 500);
//
//        jFrame.add(backGround);
        jFrame.add(contentPane);
        return jFrame;
    }
}