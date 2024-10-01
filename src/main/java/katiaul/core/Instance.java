package katiaul.core;

@SuppressWarnings("unused")
public class Instance implements Runnable {
    private final Thread thread;
    private boolean running;

    public Instance() {
        thread = new Thread(this);
        running = false;
    }

    public void start() {
        if (!thread.isAlive() && !running) {
            running = true;
            thread.start();
        }
    }

    public void stop() {
        if (thread.isAlive() || running) {
            running = false;
            thread.interrupt();
        }
    }

    public void begin() {

    }

    public void loop() {

    }

    public void end() {

    }

    @Override
    public void run() {
        begin();
        while (running) {
            loop();
        }
        end();
    }
}
