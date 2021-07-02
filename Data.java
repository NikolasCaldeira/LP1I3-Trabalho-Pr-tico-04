package entities;

import java.util.Scanner;
import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;

public class Data {
    Scanner ler = new Scanner(System.in);
    private int dia;
    private int mes;
    private int ano;

    public Data() {
        setDi();
        setMe();
        setAn();
    }

    public Data(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.ano = a;
    }

    public void setDi(int d) {
        this.dia = d;
    }

    public void setMe(int m) {
        this.mes = m;
    }

    public void setAn(int a) {
        this.ano = a;
    }

    public void setDi() {
        do {
            System.out.print("Digite o dia: ");
            dia = ler.nextInt();
        } while (dia > 31 || dia <= 0);
    }

    public void setMe() {
        do {
            System.out.print("Digite o mês: ");
            mes = ler.nextInt();
        } while (mes > 12 || mes <= 0);
    }

    public void setAn() {
        do {
            System.out.print("Digite o ano: ");
            ano = ler.nextInt();
        } while (ano < 0);
    }

    public int getDi() {
        return dia;
    }

    public int getMe() {
        return mes;
    }

    public int getAn() {
        return ano;
    }

    public String getMostra1() {
        String dt1 = (dia + "/" + mes + "/" + ano);
        return dt1;
    }

    public String getMostra2() {
        String dt2;
        int ms = this.mes;
        String meses[] = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "outubro", "Novembro", "Dezembro" };

        int cont = 0;
        cont = ms - 1;

        dt2 = ("Dia " + dia + " de " + meses[cont] + " de " + ano);
        return dt2;
    }

    public String getBisexto(){
        int ao = this.ano;
        if(ao % 4 == 0 ){
            return "O ano " + ao + " é bisexto";
        }else {
            return "O ano " + ao + " não é bisexto";
        }
    }

    public int getDiasTranscorridos(){
        int da = this.dia;
        int ms = this.mes;
        int ao = this.ano;
        int dtc=0;
        int armz=0;
        int meses[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (ao % 4 == 0)
        {
            meses[1]++;
        }
        for (int i = 0 ; i < (ms-1); i++ )
        {
            dtc += meses[i] ;
        }
        armz = dtc + da;
        return armz;
    }

    public static void main(String[] args) {
        Data data = new Data();
        data.getMostra1();
        data.getMostra2();
        data.getBisexto();
        
        System.out.println("\n" + data.getMostra1());
        System.out.println(data.getMostra2());
        System.out.println(data.getBisexto());

        data.getDiasTranscorridos();
        System.out.println("A quantidade de dias transcorridos foram: " + data.getDiasTranscorridos() + " dias");

        Calendar c = Calendar.getInstance();
		Date dat = c.getTime();

		DateFormat f = DateFormat.getDateInstance(DateFormat.FULL); //Data Completa
		System.out.println("Data brasileira atual: "+ f.format(dat));

    }
}
