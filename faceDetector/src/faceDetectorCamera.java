import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

public class faceDetectorCamera {
    public String inputFile;
    public String outputFile;
    public int faceCount;

    public faceDetectorCamera(String inputFile, String outputFile, int faceCount) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.faceCount = faceCount;
    }

    public void faceDetectCamera() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture camera = new VideoCapture(0);

        if (!camera.isOpened()) {
            System.out.println("Error! Camera could not be opened!");
            return;
        }

        Mat faceCam = new Mat();
        if (camera.read(faceCam)){
            Imgcodecs.imwrite(inputFile, faceCam);
        }

        Mat faceImage1 = Imgcodecs.imread(inputFile);
        String xmlFile = "haarcascade_frontalface_default.xml";
        CascadeClassifier classifier = new CascadeClassifier(xmlFile);
        MatOfRect faces = new MatOfRect();
        classifier.detectMultiScale(faceImage1, faces);

        for (Rect rect : faces.toArray()) {
            Imgproc.rectangle(
                    faceImage1,
                    new Point(rect.x, rect.y),
                    new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 0, 255), 3
            );
        }
        faceCount = faces.toArray().length;
        Imgcodecs.imwrite(outputFile, faceImage1);
        camera.release();
    }
}