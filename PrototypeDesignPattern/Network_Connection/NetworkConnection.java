public class NetworkConnection implements Cloneable{
    String ip, impData;

    public String getIp() {
        return ip;
    }

    public String getimpData() {
        return impData;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setimpData(String impData) {
        this.impData = impData;
    }
    
    public void loadVeryImpData(){
        try {
            Thread.sleep(2000);
            this.impData = "Very very important data";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        return ("IP: " + ip + "\nIMP DATA: " + impData);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
