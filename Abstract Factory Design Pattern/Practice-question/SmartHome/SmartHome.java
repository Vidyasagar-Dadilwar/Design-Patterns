interface Lightning{
    void on();
    void off();
}

interface Fan{
    void setSpeed();
    void on();
    void off();
}

interface Camera{
    void record();
    void liveStream();
}

class Cmp1Light implements Lightning {
    public void on() {
        System.out.println("Light on using Cmp1");
    }
    public void off(){
        System.out.println("Light off using Cmp1");
    }
}

class Cmp1Fan implements Fan {
    public void setSpeed(){
        System.out.println("Setting speed of Cmp1 fan");
    }
    public void on() {
        System.out.println("Fan on using Cmp1");
    }

    public void off() {
        System.out.println("Fan off using Cmp1");
    }
}

class Cmp1Camera implements Camera {
    public void record() {
        System.out.println("Recording using Cmp1");
    }

    public void liveStream() {
        System.out.println("Live streaming using Cmp1");
    }
}



class Cmp2Light implements Lightning {
    public void on() {
        System.out.println("Light on using Cmp2");
    }

    public void off() {
        System.out.println("Light off using Cmp2");
    }
}

class Cmp2Fan implements Fan {
    public void setSpeed() {
        System.out.println("Setting speed of Cmp2 fan");
    }

    public void on() {
        System.out.println("Fan on using Cmp2");
    }

    public void off() {
        System.out.println("Fan off using Cmp2");
    }
}

class Cmp2Camera implements Camera {
    public void record() {
        System.out.println("Recording using Cmp2");
    }

    public void liveStream() {
        System.out.println("Live streaming using Cmp2");
    }
}



interface SmartDeviceFactory{
    Lightning createLightning();
    Fan createFan();
    Camera createCamera();
}


class Cmp1Factory implements SmartDeviceFactory {
    public Lightning createLightning() {
        return new Cmp1Light();
    }

    public Fan createFan() {
        return new Cmp1Fan();
    }

    public Camera createCamera() {
        return new Cmp1Camera();
    }
}


class Cmp2Factory implements SmartDeviceFactory {
    public Lightning createLightning() {
        return new Cmp2Light();
    }

    public Fan createFan() {
        return new Cmp2Fan();
    }

    public Camera createCamera() {
        return new Cmp2Camera();
    }
}


class SmartHomeAutomationSystem {
    Lightning lightning;
    Fan fan;
    Camera camera;

    public SmartHomeAutomationSystem(SmartDeviceFactory smartDeviceFactory) {
        this.lightning = smartDeviceFactory.createLightning();
        this.fan = smartDeviceFactory.createFan();
        this.camera = smartDeviceFactory.createCamera();
    }

    void execute() {
        this.lightning.on();
        this.lightning.off();
        this.fan.on();
        this.fan.setSpeed();
        this.fan.off();
        this.camera.record();
        this.camera.liveStream();
    }
}


public class SmartHome{
    public static void main(String[] args) {
        SmartHomeAutomationSystem sh1 = new SmartHomeAutomationSystem(new Cmp1Factory());
        sh1.execute();

        SmartHomeAutomationSystem sh2 = new SmartHomeAutomationSystem(new Cmp2Factory());
        sh2.execute();
    }
}