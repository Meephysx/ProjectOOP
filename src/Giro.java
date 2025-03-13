public class Giro extends Rekening {
    double limitPenarikan;

public Giro(String namaPemilik, String nomorRekening, double saldo, double limitPenarikan) {
    super(namaPemilik, nomorRekening, saldo);
    this.limitPenarikan = limitPenarikan;
}

public double getLimitPenarikan() {
    return limitPenarikan;
}

public void setLimitPenarikan(double limitPenarikan) {
    this.limitPenarikan = limitPenarikan;
}

public void setor(double jumlahPenarikan) {
    super.addSetor(jumlahPenarikan);
}

public void setor(double jumlahPenarikan, double limitPenarikan) {
    if (jumlahPenarikan <= limitPenarikan) {
        super.addTarik(jumlahPenarikan);
    } else {
        System.out.println("Penarikan melebihi limit penarikan");
    }

    }
}
