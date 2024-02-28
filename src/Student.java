public class Student {
    Course c1;
    Course c2;
    Course c3;
    String name;
    String stuNo;
    String classes;
    double avarage;
    boolean isPass;

    Student(String name, String stuNo, String classes, Course c1, Course c2, Course c3) {
        this.name = name;
        this.stuNo = stuNo;
        this.classes = classes;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.avarage = 0.0;
        this.isPass = false;
    }

    void addBulkExamNote(int note1, int snote1, int impact1, int note2, int snote2, int impact2, int note3, int snote3, int impact3) {
        if (note1 >= 0 && note1 <= 100) {
            this.c1.note = note1;
        }

        if (note2 >= 0 && note2 <= 100) {
            this.c2.note = note2;
        }

        if (note3 >= 0 && note3 <= 100) {
            this.c3.note = note3;
        }

        if (snote1 >= 0 && snote1 <= 100) {
            this.c1.sNote = snote1;
        }

        if (snote2 >= 0 && snote2 <= 100) {
            this.c2.sNote = snote2;
        }

        if (snote3 >= 0 && snote3 <= 100) {
            this.c3.sNote = snote3;
        }

        if (impact1 >= 0 && impact1 <= 100) {
            this.c1.sNoteImpectRate = impact1;
        }

        if (impact2 >= 0 && impact2 <= 100) {
            this.c2.sNoteImpectRate = impact2;
        }

        if (impact3 >= 0 && impact3 <= 100) {
            this.c3.sNoteImpectRate = impact3;
        }

    }

    double avarage() {

        double c1 = (this.c1.note * (1 - (this.c1.sNoteImpectRate / 100.0))) + (this.c1.sNote * ((this.c1.sNoteImpectRate / 100.0)));
        double c2 = (this.c2.note * (1 - (this.c2.sNoteImpectRate / 100.0))) + (this.c2.sNote * ((this.c2.sNoteImpectRate / 100.0)));
        double c3 = (this.c3.note * (1 - (this.c3.sNoteImpectRate / 100.0))) + (this.c3.sNote * ((this.c3.sNoteImpectRate / 100.0)));

        this.avarage = (c1 + c2 + c3) / 3.0;

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        return this.avarage;
    }

    void isPass() {
        this.avarage = this.avarage();
        System.out.println("=====================================");
        if (this.avarage > 55) {
            System.out.println("Sınıfı başarıyla geçtiniz.");
            this.isPass = true;
        } else {
            System.out.println("Sınıfta kaldınız.");
            this.isPass = false;
        }

        printNote();
    }

    void printNote() {
        System.out.println(this.c1.name + " Notu : " + this.c1.note);
        System.out.println(this.c2.name + " Notu : " + this.c2.note);
        System.out.println(this.c3.name + " Notu : " + this.c3.note);
        System.out.println("Ortalamanız : " + this.avarage);
    }

}
