package baitap;

import java.util.Scanner;
import java.util.Arrays;

abstract class NhanVien{
    protected int maNV;
    protected String hoTen;
    protected String diaChi;

    public NhanVien(){}

    public NhanVien(int maNV, String hoTen, String diaChi){
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
    }
    public int getMANV(){
        return maNV;
    }
    public void setMANV(int maNV){
        this.maNV = maNV;
    }
    public String getHoTen(){
        return hoTen;
    }
    public void setHoTen(String hoTen){
        this.hoTen = hoTen;
    }
    public String getDiaChi(){
        return diaChi;
    }
    public void setDiaChi(String diaChi){
        this.diaChi = diaChi;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ma: "); maNV = sc.nextInt();sc.nextLine();
        System.out.print("Ho ten : "); hoTen = sc.nextLine();
        System.out.print("Dia chi : "); diaChi = sc.nextLine();
    }

    public void xuat(){
        System.out.println("Ma: " + maNV);
        System.out.println("Ho ten: " + hoTen);
        System.out.println("Dia chi: " + diaChi);
    }
    public abstract double tinhTienLuong();
    
}

class NhanVienSanXuat extends NhanVien{
    private int soSanPham;

    public NhanVienSanXuat(){}

    public NhanVienSanXuat(int a, String b, String c, int soSanPham){
        super(a,b,c);
        this.soSanPham = soSanPham;
    }

    public int getSoSanPham(){
        return soSanPham;
    }
    public void setSoSanPham(int soSanPham){
        this.soSanPham = soSanPham;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.print("So san pham: "); soSanPham = sc.nextInt();
    }
    public void xuat(){
        super.xuat();
        System.out.println("So san pham: "+ soSanPham);
        System.out.println("Tien luong: "+ tinhTienLuong());
    }
    @Override
    public double tinhTienLuong(){
        double tienLuong = soSanPham * 20000;
        return tienLuong;
    }
}
class NhanVienCongNhat extends NhanVien{
    private int soNgayCong;

    public NhanVienCongNhat(){}

    public NhanVienCongNhat(int a, String b, String c,int soNgayCong){
        super(a,b,c);
        this.soNgayCong = soNgayCong;
    }
    public int getSoNgayCong(){
        return soNgayCong;
    }
    public void setSoNgayCong(int soNgayCong){
        this.soNgayCong = soNgayCong;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.print("So ngay cong : ");
        soNgayCong = sc.nextInt();
    }
    public void xuat(){
        super.xuat();
        System.out.println("So ngay cong : "+soNgayCong);
        System.out.println("Tien luong : "+ tinhTienLuong());
    }

    @Override
    public double tinhTienLuong(){
        double tienLuong = soNgayCong * 50000;
        return tienLuong;
    }

}

class NhanVienQuanLi extends NhanVien{
    private int heSoLuong;
    private double luongCoBan;

    public NhanVienQuanLi(){}

    public NhanVienQuanLi(int a, String b, String c, int heSoLuong, double luongCoBan){
        super(a,b,c);
        this.heSoLuong = heSoLuong;
        this.luongCoBan = luongCoBan;
    }

    public int getHeSoLuong(){
        return heSoLuong;
    }
    public double getLuongCoBan(){
        return luongCoBan;
    }
    public void setHeSoLuong(int heSoLuong){
        this.heSoLuong = heSoLuong;
    }
    public void setLuongCoBan(double luongCoBan){
        this.luongCoBan = luongCoBan;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.print("He so luong : ");heSoLuong = sc.nextInt();
        System.out.print("Luong Co ban : "); luongCoBan = sc.nextDouble();
    }
    public void xuat(){
        super.xuat();
        System.out.println("He so luong : "+heSoLuong);
        System.out.println("Luong Co ban : "+luongCoBan);
        System.out.println("Tien luong : "+tinhTienLuong());
    }

    @Override
    public double tinhTienLuong(){
        double tienLuong = heSoLuong * luongCoBan;
        return tienLuong;
    }
}
class DanhSachNhanVien{
    NhanVien[] nv;
    private int n;

    Scanner sc = new Scanner(System.in);

    public DanhSachNhanVien(){};

    public NhanVien[] getNV(){
        return nv;
    }
    public void setNV(NhanVien[] nv){
        this.nv = nv;
    }

    public void NhapDanhSach(){
        System.out.print("So nhan vien muon them : ");
        n = sc.nextInt();
        nv = new NhanVien[n];
        int select =0;
        for(int i=0; i<n; i++){
            System.out.println("1. Nhan Vien San Xuat");
            System.out.println("2. Nhan VieN Cong Nhat");
            System.out.println("3.Nhan Vien Quan Li");
            do{
                System.out.print("Lua cho cua ban : ");
                select = sc.nextInt();
                if(select <1 || select >3){
                    System.out.println("Sai du lieu");
                }
            }while(select < 1|| select >3);
            if(select ==1){
                nv[i] = new NhanVienSanXuat();
                nv[i].nhap();
            }
            else if(select ==2){
                nv[i] = new NhanVienCongNhat();
                nv[i].nhap();
            }
            else{
                nv[i] = new NhanVienQuanLi();
                nv[i].nhap();
            }
        }
    }

    public void XuatDanhSach(){
        for(int i=0; i<n; i++){
            nv[i].xuat();
        }
    }

    public void XuatLuong(){
        System.out.println("Nhap ma nhan vien can xuat luong: ");
        int manv = sc.nextInt();
        boolean flag = false;
        for(int i=0;i<n;i++){
            if (nv[i].getMANV() ==manv) {
                System.out.println("Tien luong cua nhan vien co ma "+manv+" la : "+nv[i].tinhTienLuong());
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println("Khong tim thay nhan vien co ma: "+manv);
            }
    }
    
    public void tinhTongLuong(){
        double tongLuong = 0.0;
        for(int i=0;i<n;i++){
            tongLuong += nv[i].tinhTienLuong();
        }
        System.out.println("Tong luong cua toan bo nhan vien la : "+tongLuong);
    }
    
    public void them(){
        int sl =1;
        n += sl;
        nv = Arrays.copyOf(nv, n);
        Scanner sc = new Scanner(System.in);
        int select =0;
        for(int i= n-sl; i<n; i++){
            System.out.println("1. Nhan Vien San Xuat");
            System.out.println("2. Nhan Vien Cong Nhat");
            System.out.println("3. Nhan Vien Quan Li");
            do{
                System.out.print("Lua chon cua ban la : ");
                select = sc.nextInt();
                if(select <1 || select >3){
                    System.out.println("Ban nhap sai du kien");
                }
                
            }while(select <1|| select >3);
            if(select ==1){
                nv[i] = new NhanVienSanXuat();
                nv[i].nhap();
            }
                    
            if(select ==2){
                 nv[i] = new NhanVienCongNhat();
                 nv[i].nhap();
            }
                   
           if(select ==3){
                    nv[i] = new NhanVienQuanLi();
                    nv[i].nhap();
           }      
        }
    }
    
    public void xoa(){
        Scanner sc =  new Scanner(System.in); 
        System.out.print("Nhap vao ma nhan vien ban muon xoa: ");
        int manv = sc.nextInt();
        int j=0;
        boolean flag = false;
        for(int i=0; i<n ;i++){
            if(nv[i].getMANV() == manv){
                j =i;
                flag = true;
                break;
            }
        }
        for(int i =j;i<n-1;i++){
            nv[i] = nv[i+1];
        }
        n--;
        if(flag){
            System.out.println("Da xoa thanh cong nhanvien co ma: "+manv);
        }else{
            System.out.println("Khong tim thay nhan vien co ma "+ manv);
        }
    }
}

public class baitap1{
    public static void main(String[] args){
        DanhSachNhanVien nv = new DanhSachNhanVien();
        Scanner sc = new Scanner(System.in);
        int select =0;
        loop: 
            while(true){
                System.out.println("1. Nhap Danh Sach");
                System.out.println("2. Xuat Danh Sach");
                System.out.println("3. Xuat Luong ");
                System.out.println("4. Tinh tong luong");
                System.out.println("5. Them 1 nhan vien.");
                System.out.println("6. Xoa nhan vien");
                System.out.println("7. Thoat");
                System.out.print("Lua chon: ");
                select = sc.nextInt();
                switch(select){
                    case 1: 
                         nv.NhapDanhSach();
                         break;
                    case 2: 
                         nv.XuatDanhSach();
                         break;
                    case 3: 
                         nv.XuatLuong();
                         break;
                    case 4: 
                         nv.tinhTongLuong();
                         break;
                    case 5: 
                         nv.them();
                         break;
                    case 6: 
                         nv.xoa();
                         break;
                    case 7: 
                         break loop;
                    default:
                        System.out.println("Sai du kien dau vao");
                        continue loop;
                }
            }
    }
}