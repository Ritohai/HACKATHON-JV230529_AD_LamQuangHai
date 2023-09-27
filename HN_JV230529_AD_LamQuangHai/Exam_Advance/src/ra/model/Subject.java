package ra.model;

import java.util.Scanner;

public class Subject {
    private String subjectId;
    private String subjectName;

    public Subject() {
    }

    public Subject(String subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void inputData(Subject[] arrSubject){
        Scanner scanner = new Scanner(System.in);
        // Nhập mã môn học
        System.out.println("Nhập mã môn học");
        this.subjectId = scanner.nextLine();
        while (!subjectId.matches("^MH\\d{3}$")){
            System.out.println("Mã môn học không hợp lệ. Vui lòng nhập lại");
            this.subjectId = scanner.nextLine();
        }
        boolean checkId = true;
        while (checkId){
            if (issubjectIdDuplicate(arrSubject, this.subjectId)){
                System.out.println("Mã sản phẩm bị trùng, nhập lại : ");
                this.subjectId = scanner.nextLine();
            }
            else {
                checkId = false;
            }
        }

        // Nhập tên môn học
        System.out.println("Nhập tên môn học");
        this.subjectName = scanner.nextLine();
        boolean checkName = true;
        while (checkName){
            if (issubjectNameDuplicate(arrSubject, this.subjectName)){
                System.out.println("Tên môn học bị trùng, nhập lại : ");
                this.subjectName = scanner.nextLine();
            }
            else {
                checkName = false;
            }
        }
    }
    public void displayData(Subject subjects) {
        System.out.println("Mã môn học: " + subjects.subjectId);
        System.out.println("Tên môn học: " + subjects.subjectName);

    }
    // Check trùng mã môn hoc
    private boolean issubjectIdDuplicate(Subject[] arrSubject, String newSubjectId) {
        for (Subject subject : arrSubject) {
            if (subject != null && subject.getSubjectId().equals(newSubjectId)) {
                return true;
            }
        }
        return false;
    }

    // Check trùng tên môn học
    private boolean issubjectNameDuplicate(Subject[] arrSubject, String newSubjectName) {
        for (Subject subject : arrSubject) {
            if (subject != null && subject.getSubjectName().equals(newSubjectName)) {
                return true;
            }
        }
        return false;
    }
}
