package Condition.src;
public class NhanVien {
    private double luong;
    private Grade capBac;

    public NhanVien() {
    }

    public NhanVien(double luong, String capBac) {
        this.luong = luong;
        if(capBac.compareToIgnoreCase("A")==0){
        this.capBac =Grade.A;
        }else if (capBac.compareToIgnoreCase("B")==0)
        {
            this.capBac =Grade.B;
        }else
            this.capBac=Grade.other;
    }

    public double getLuong() {
        return luong;
    }

    public Grade getCapBac() {
        return capBac;
    }
}
public abstract int TinhLuong(int luong);
