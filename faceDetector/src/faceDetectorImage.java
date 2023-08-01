import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class faceDetectorImage {
    public String inputFile;
    public String outputFile;
    public int faceCount;

    public faceDetectorImage(String inputFile, String outputFile, int faceCount) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.faceCount = faceCount;
    }

    public void faceDetectImage() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat faceImage2 = Imgcodecs.imread(inputFile);
        String xmlFile = "haarcascade_frontalface_default.xml";
        CascadeClassifier classifier = new CascadeClassifier(xmlFile);

        MatOfRect faceDetections = new MatOfRect();
        classifier.detectMultiScale(faceImage2, faceDetections);

        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(
                    faceImage2,
                    new Point(rect.x, rect.y),
                    new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 0, 255),
                    3
            );
        }
        faceCount = faceDetections.toArray().length;
        Imgcodecs.imwrite(outputFile, faceImage2);
    }
}