package homework5.task2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
2. Предполож мить, что числа в исходном массиве из 9 элементов имеют диапазон [0, 3], и представляют собой, например,
состояния ячеек поля для игры в крестикинолики, где 0 – это пустое поле, 1 – это поле с крестиком,
2 – это поле с ноликом, 3 – резервное значение. Такое предположение позволит хранить в одном числе типа int всё поле 3х3.
Записать в файл 9 значений так, чтобы они заняли три байта.
Прочитать числа из файла, полученного в результате выполнения задания.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 0, 1, 2, 3, 1};
        try (FileOutputStream fileOutputStream = new FileOutputStream("save.out")) {
            for (int i = 0; i < 3; i++) {
                byte res = 0;
                for (int j = 0; j < 3; j++) {
                    res += (byte) (array[3 * i + j] << (j * 2));
                }
                fileOutputStream.write(res);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        int[] array2 = new int[9];
        int b;
        int i = 0;
        try (FileInputStream fileInputStream = new FileInputStream("save.out")) {
            while ((b = fileInputStream.read()) != -1) {
                for (int j = 0; j < 3; j++) {
                    array2[i++] = b >> (j * 2) & 0x3;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int el : array2) {
            System.out.println(el);
        }
    }
}
