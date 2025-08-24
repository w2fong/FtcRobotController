public class ServoTuner {
    private Servo servo;
    private double position;

    public ServoTuner(Servo servo, double startPos) {
        this.servo = servo;
        this.position = startPos;
    }

    public void adjust(double delta) {
        position = Math.max(0.0, Math.min(1.0, position + delta));
        servo.setPosition(position);
    }

    public double getPosition() {
        return position;
    }
}