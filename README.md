# Face Detection Program with OpenCV in Java
This project is a Java-based face detection program that utilizes OpenCV to detect faces in images. <br> 
The program employs the frontalface.xml Haar cascade classifier to achieve accurate face detection. <br>
Additionally, a Java Swing GUI is implemented, offering two main functionalities: <br>
● Capturing faces from a camera feed, <br>
● Detecting faces in a user-selected image file. <br>

## Features
Face detection using OpenCV and frontalface.xml Haar cascade. <br>
In menu you can see two options which they are: <br>
**Take Photo via Camera** : The program captures an image from the camera feed and highlights the detected faces in rectangles. It displays the number of detected faces on the image. <br>
**Upload a Image**: The user can choose an image file, and the program detects faces within it. It highlights the faces in rectangles and displays the total number of detected faces. <br>

## Usage
Compile the Java source code and run the application. <br>
Upon launching the program, the Java Swing GUI will appear, displaying two options below "Take Photo via Camera", "Upload a Image" and displaying "How to Use" options above of the main screen. <br>

### Camera Capture:
Click the "Take Photo via Camera" button to open the camera feed. It'll take photo automatically. <br>
The program will process the image and draw rectangles around detected faces, along with the total number of faces detected. <br>
The number of faces in the picture taken from the camera will be shown as a notification on the screen. <br>
You can find the captured image and the marked faces within the file where the program is installed.

### Image Processing:
**WARNING: BEFORE USE A IMAGE PLEASE TAKE A BACKUP OF THAT PHOTO** <br>
Click the "Upload a Image" button to select an image file from your local machine. <br>
The program will process the selected image and draw rectangles around detected faces on selected image <br>
It processes on the selected image instead of creating a new one. <br>
The number of faces in the picture taken from the image will be shown as a notification on the screen. <br>
In addition, it will put rectangles around the faces on the selected image so you can see detected faces in your photo. <br>
