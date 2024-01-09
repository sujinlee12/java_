package test;
import java.io.*;
import java.io.Serializable;

class Food implements Serializable {
    private String name;
    private int kcal;

    public Food() {
    }

    public Food(String name, int kcal) {
        this.name = name;
        this.kcal = kcal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    @Override
    public String toString() {
        return "음식명: " + name + ", 칼로리: " + kcal + " kcal";
    }

    public void fileSave(String fileName) {
        try {
            // 파일 객체 생성
            File file = new File(fileName);

            // 파일 출력 스트림 생성
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            // 객체 출력 스트림 생성
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // Food 객체 생성 및 정보 기록
            Food foodSample = new Food("사과", 20);
            objectOutputStream.writeObject(foodSample);

            // 스트림 닫기
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}