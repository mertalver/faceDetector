import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main {
    public static void main(String[] args) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        //Creating GUI with resolution friendly.
        JFrame frame = new JFrame("Face Detector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x,y);

        //Set a main photo for main screen of GUI
        ImageIcon icon = new ImageIcon("main.png");
        JLabel label = new JLabel(icon);
        frame.add(label);

        //Creating a menu-bar for users
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.white);
        JButton button = new JButton("How To Use");
        button.setBackground(Color.white);
        menuBar.add(button);

        //Creating two different usage way for users.
        JPanel buttonPanel = new JPanel();
        JButton menuButton1 = new JButton("Take Photo via Camera");
        JButton menuButton2 = new JButton("Upload a Image");
        buttonPanel.add(menuButton1);
        buttonPanel.add(menuButton2);
        menuButton1.setBackground(Color.white);
        menuButton2.setBackground(Color.white);
        buttonPanel.setBackground(Color.white);


        //"How to Use" button message
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(frame, "Hello! First of all, thank you for downloading the application\n"+
                        "As for the usage part, as it is written on the first option, it will take your photo through the camera\n"+
                        "and print how many faces are on the screen, then it will square the faces in the photo.\n"+
                        "The second option will do this process through an image you upload.\n"+
                        "All operations are done through files with .jpg extension.\n");
            }
        });

        //"Take Photo via Camera" button events
        menuButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String inputFileName = "takenPhoto.jpg";
                String outputFileName = "detectedfaces_output.jpg";
                faceDetectorCamera faceDetectionCamera = new faceDetectorCamera(inputFileName, outputFileName, 0);
                faceDetectionCamera.faceDetectCamera();
                JOptionPane.showMessageDialog(frame,"Photo has taken\n"+ faceDetectionCamera.faceCount+" faces detected");
            }
        });

        //"Upload a Image" button events
        menuButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("JPG, JPEG and PNG Images", "jpg", "png", "jpeg");
                fileChooser.setFileFilter(fileFilter);
                int returnVal = fileChooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();
                    filePath = filePath.replace("\\", "\\\\");
                    if (selectedFile.isFile()) {
                        faceDetectorImage faceDetectionImage = new faceDetectorImage(filePath, filePath, 0);
                        faceDetectionImage.faceDetectImage();
                        JOptionPane.showMessageDialog(frame, "Upload has done.\n"+faceDetectionImage.faceCount + " faces detected in the uploaded photo");
                    }
                    else {
                        JOptionPane.showMessageDialog(frame, "Wrong file selected. Please select correct file.");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(frame, "File selection canceled.");
                }
            }
        });

        //Setting menu-bar and button-panel places.
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        frame.setVisible(true);
    }
}
