import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {


    //Объект таблицы
    JTable jTableCompressor;
    UnitComplect unitComplect;
    TableModel tableModel;
    JButton buttonSelect, buttonClear;
    JScrollPane jscrlp;
    PanelWithBackground panel, backgroundOAandOH;
    JTextField textFieldReuiredCapacity;
    JTextField textFieldEvaporatingTemperature;
    JTextField textFieldAirInletTemperature, textFieldAmbientTemperature;


    public static void main(String[] args) {
        //Создаем фрейм в потоке обработки событий
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }

    private Main() {
        JFrame window = new JFrame("Программа подбора");//Создаем новый контейнер JFrame
        window.getContentPane().setLayout(new FlowLayout());//Устанавливаем диспетчер компоновки
        window.setSize(700, 500);//Устанавливаем размер окна
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Устанавливаем завершение программы при закрытии окна
        panel = new PanelWithBackground("BackgroundOstrov.jpg");
        panel.setLayout(null);
        unitComplect = new UnitComplect();
        ArrayList complectList = unitComplect.getUnits();
        tableModel = new TableModel(complectList); //Создаем модель таблицы
        jTableCompressor = new JTable(tableModel); //Создаем таблицу на основе модели
        buttonSelect = new JButton("Расчитать");
        buttonSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//Создаем действие кнопки
                try {
                    jscrlp.setVisible(true);
                    backgroundOAandOH.setVisible(false);
                    double capacity = Double.parseDouble(textFieldReuiredCapacity.getText());
                    capacity = (double) (capacity * 1000);
                    double eveTemperature = Double.parseDouble(textFieldEvaporatingTemperature.getText());
                    double condTemperature = Double.parseDouble(textFieldAmbientTemperature.getText());
                    double airInletTemperature = Double.parseDouble(textFieldAirInletTemperature.getText());
                    if (capacity < 0 | eveTemperature < -40 | eveTemperature > 4 | airInletTemperature > 14 | condTemperature < 30 | condTemperature > 50 | airInletTemperature < eveTemperature | (Math.abs(airInletTemperature - eveTemperature) < 4)) {
                        throw new ArithmeticException();
                    }
                    complectList.removeAll(complectList.subList(0, complectList.size())); // удавление всех элементов из старого массива
                    UnitComplect unitComplect = new UnitComplect(capacity, eveTemperature, condTemperature, airInletTemperature); //создание нового компрессора для расчета
                    for (int i = 0; i < unitComplect.getUnits().size(); i++) {
                        complectList.add(unitComplect.getUnits().get(i)); //добавление компрессоров в список
                    }
                    tableModel.fireTableDataChanged(); //обновить таблицу
                } catch (ArithmeticException arithmeticException) {
                    jscrlp.setVisible(false);
                    JOptionPane.showMessageDialog(null,
                            "Холодопроизводительность меньше 0 кВт; " +
                                    "\nТемпература кипения в диапозоне от -40\u00B0 до +4\u00B0С;" +
                                    "\nТемпература окружающей среды от +15\u00B0 до +35\u00B0С;" +
                                    "\nТемпература в охлаждаемом объеме в диапозоне от -30\u00B0C до +14\u00B0C;" +
                                    "\nТемпература кипения должна быть меньше температуры в охлаждаемом объеме" +
                                    "\nМинимальная разница температур 4 градуса");


                } catch (Exception exception) {
                    jscrlp.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Заполнено не допустимыми значениями!");
                }
            }
        });
        buttonClear = new JButton("Очистить");
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jscrlp.setVisible(false);
                backgroundOAandOH.setVisible(true);
                textFieldAirInletTemperature.setText("0.0");
                textFieldAmbientTemperature.setText("45.0");
                textFieldEvaporatingTemperature.setText("-8.0");
                textFieldReuiredCapacity.setText("10.0");
            }
        });
        panel.add(buttonSelect); //Добавляем кнопку на панель
        panel.add(buttonClear);
        jscrlp = new JScrollPane(jTableCompressor);//Создаем панель прокрутки и включаем в ее состав нашу таблицу
        jTableCompressor.setPreferredScrollableViewportSize(new Dimension(500, 150)); //Устаналиваем размеры прокручиваемой области
        panel.add(jscrlp);//Добавляем в панель прокрутки нашу панель прокрути и таблицу вместе с ней
        AddElements();
        window.add(panel);
        jscrlp.setBounds(30, 200, 640, 245);
        buttonSelect.setBounds(30, 10, 100, 25);
        buttonClear.setBounds(140, 10, 100, 25);
        jscrlp.setVisible(false);
        window.setContentPane(panel);
        window.setVisible(true);//Отображаем контейнер
        window.setResizable(false); // Блокируем изменение размеров
        window.setLocationRelativeTo(null); //Ввывод окна по середине экрана
    }

    public class TableModel extends AbstractTableModel {
        ArrayList<Unit> complect;

        public TableModel(ArrayList<Unit> complect) {
            super();
            this.complect = complect;
        }

        @Override
        public String getColumnName(int column) {
            String columnName = "";
            switch (column) {
                case 0:
                    columnName = "Наименование";
                    break;
                case 1:
                    columnName = "Холодопроизводительность, кВт";
                    break;
                case 2:
                    columnName = "Мощность, кВт";
                    break;
            }
            return columnName;
        }

        @Override
        public int getRowCount() {
            return complect.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return complect.get(rowIndex).getName();
                case 1:
                    double result = (double) complect.get(rowIndex).getCapacity() / 1000;
                    result = Math.rint(100.0 * result) / 100.0;
                    if (result > 0) {
                        return result;
                    } else return "";
                case 2:
                    double result2 = (double) complect.get(rowIndex).getPower() / 1000;
                    result2 = Math.rint(100.0 * result2) / 100.0;
                    if (result2 > 0) {
                        return result2;
                    } else return "";
                default:
                    return "";
            }
        }
    }

    public class PanelWithBackground extends JPanel {
        private Image backgroundImage;

        public PanelWithBackground(String src) {
            try {
                backgroundImage = ImageIO.read(getClass().getResource(src));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, this);
        }
    }

    public void AddElements() {
        JLabel labelReuiredCapacity = new JLabel("Холодопроизводительность:");
        textFieldReuiredCapacity = new JTextField("10.0");
        JLabel labelKw = new JLabel("кВт");
        JLabel labelEvaporatingTemperature = new JLabel("Температура кипения:");
        textFieldEvaporatingTemperature = new JTextField("-8.0");
        JLabel labeldegree1 = new JLabel("\u00B0C");
        JLabel labelAirInletTemperature = new JLabel("Температура в охлаждаемом объеме:");
        textFieldAirInletTemperature = new JTextField("0.0");
        JLabel labeldegree2 = new JLabel("\u00B0C");
        JLabel labelAmbientTemperature = new JLabel("Температура конденсации:");
        textFieldAmbientTemperature = new JTextField("45.0");
        JLabel labeldegree3 = new JLabel("\u00B0C");
        backgroundOAandOH = new PanelWithBackground("BG_OHandOA.jpg");
        JLabel labelSuperHeat = new JLabel("Перегрев:");
        JLabel labelGas507a = new JLabel("R507A");
        JLabel labelGas = new JLabel("Хладагент:");


        panel.add(labelReuiredCapacity);
        panel.add(textFieldReuiredCapacity);
        panel.add(labelKw);
        panel.add(labelEvaporatingTemperature);
        panel.add(textFieldEvaporatingTemperature);
        panel.add(labeldegree1);
        panel.add(labelAirInletTemperature);
        panel.add(textFieldAirInletTemperature);
        panel.add(labeldegree2);
        panel.add(labelAmbientTemperature);
        panel.add(textFieldAmbientTemperature);
        panel.add(labeldegree3);
        panel.add(backgroundOAandOH);
        panel.add(labelGas);
        panel.add(labelGas507a);


        labelReuiredCapacity.setBounds(30, 40, 250, 25);
        textFieldReuiredCapacity.setBounds(300, 40, 35, 25);
        labelKw.setBounds(340, 40, 35, 25);
        labelEvaporatingTemperature.setBounds(30, 70, 250, 25);
        textFieldEvaporatingTemperature.setBounds(300, 70, 35, 25);
        labeldegree1.setBounds(340, 70, 35, 25);
        labelAirInletTemperature.setBounds(30, 100, 250, 25);
        textFieldAirInletTemperature.setBounds(300, 100, 35, 25);
        labeldegree2.setBounds(340, 100, 35, 25);
        labelAmbientTemperature.setBounds(30, 130, 250, 25);
        textFieldAmbientTemperature.setBounds(300, 130, 35, 25);
        labeldegree3.setBounds(340, 130, 35, 25);
        backgroundOAandOH.setBounds(30, 200, 640, 245);
        backgroundOAandOH.setVisible(true);
        labelGas.setBounds(30, 160, 250, 25);
        labelGas507a.setBounds(300, 160, 45, 25);

    }

}


