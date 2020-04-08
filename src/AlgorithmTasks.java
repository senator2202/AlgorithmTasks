import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public  class AlgorithmTasks {

    public static void main(String[] args) {
        task7171717();
    }

    /**В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К*/
    static void task1() {
        int[] mas = {2, 15, 4, 77, 12, 31, 16, 22};
        int K = 3;
        int sum = 0;
        for (int i = 0; i < mas.length; i++)
            if (mas[i] / K > 0 && mas[i] % K == 0)
                sum += mas[i];
        System.out.println("Сумма чисел в массиве, кратных " + K + " равно " + sum);
    }

    /**Дана последовательность действительных чисел а1 ,а2 ,..., аn. Заменить все ее члены, большие данного Z, этим
     * числом. Подсчитать количество замен*/
    static void task2() {
        double[] a = {1.2, 2.1, 4.3, 5.4, 6.12, 7.6, 8.12, 9.432, 10.567, 12.123, 13.444, 14.678, 15.323};
        double Z = 8.666;
        int count = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] > Z) {
                count++;
                a[i] = Z;
            }
        System.out.println("Количество замен: " + count);
    }

    /**Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
     * положительных и нулевых элементов*/
    static void task3() {
        double[] mas = {1, -23.231, 17.777, -992, 0.0123, 14, 111, 283.00002, -228.322, 0, 3.14};
        int zero = 0;
        int plus = 0;
        int minus = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] > 0)
                plus++;
            if (mas[i] < 0)
                minus++;
            if (mas[i] == 0)
                zero++;
        }
        System.out.println("В массиве " + plus + " положительных элементов, " + minus + " отрицательных элементов, " + zero + " нулевых элементов");

    }

    /**Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы*/
    static void task4() {
        double[] mas = {1, -23.231, 17.777, -992, 0.0123, 14, 111, 283.00002, -228.322, 0, 3.14};
        int min = 0;
        int max = 0;
        double temp;
        System.out.println("Исходный массив:");
        for (int i = 0; i < mas.length; i++) {
            if (mas[min] < mas[i])
                min = i;
            if (mas[max] > mas[i])
                max = i;
            System.out.print(mas[i] + " ");
        }
        temp = mas[max];
        mas[max] = mas[min];
        mas[min] = temp;
        System.out.println("\n\nИзмененный массив:");
        for (int i = 0; i < mas.length; i++)
            System.out.print(mas[i] + " ");
    }

    /**Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i*/
    static void task5() {
        int[] a = {-1, 4, 177, -555, 0, 18, 22, -444, 12, 17, 54, -99, 22};
        for (int i = 0; i < a.length; i++)
            if (a[i] > i)
                System.out.print(a[i] + " ");
    }

    /**Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
     являются простыми числами*/
    static void task6() {
        double[] mas = {1, -23.231, 17.777, -992, 0.0123, 14, 111, 283.00002, -228.322, 0, 3.14};
        double sum = 0;
        for (int i = 0; i < mas.length; i++) {
            int count = 0;
            for (int j = 1; j <= i + 1; j++) {
                if ((i + 1) / j > 0 && (i + 1) % j == 0 && i != 0)
                    count++;
            }
            if (count == 2)//число простое
                sum += mas[i];
        }
        System.out.println("Сумма чисел с простыми порядковыми номерами равна " + sum);
    }

    /**Даны действительные числа a1,a2,...,an . Найти max( a1 + a2n,a2 + a2n−1,...,an + an+1)*/
    static void task7() {
        double[] mas = {1, -23.231, 17.777, -992, 0.0123, 14, 111, 283.00002, -228.322, 0};
        double res = mas[0] + mas[mas.length - 1];
        for (int i = 1; i < mas.length / 2; i++)
            if (mas[i] + mas[mas.length - 1 - i] > res)
                res = mas[i] + mas[mas.length - 1 - i];
        System.out.println("Максимальная сумма крайних членов последовательности равна " + res);
    }

    /**Дана последовательность целых чисел a1,a2,...,an . Образовать новую последовательность, выбросив из
     * исходной те члены, которые равны min(a1,a2,...,an)*/
    static void task8() {
        int[] a = {-11, 4, 177, -555, 0, 18, 22, -555, 12, 17, 54, -555, 22};
        int count = 0;
        int[] res;
        int min = a[0];
        System.out.println("Исходная последовательность: ");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        for (int i = 1; i < a.length; i++)
            if (a[i] <= min)
                min = a[i];
        for (int i = 0; i < a.length; i++)
            if (a[i] == min)
                count++;
        res = new int[a.length - count];
        for (int i = 0, j = 0; i < a.length; i++)
            if (a[i] != min)
                res[j++] = a[i];
        System.out.println("\nНовая последовательность: ");
        for (int i = 0; i < res.length; i++)
            System.out.print(res[i] + " ");
    }

    /**В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
     * чисел несколько, то определить наименьшее из них*/
    static void task9() {
        int[] mas = {44, 44, 177, -555, 44, 18, 22, -444, 22, 17, 44, -99, 22};
        int[] count = new int[mas.length];
        for (int i = 0; i < mas.length; i++) {//для каждого числа записыаем количество его повторов в новый массив
            int c = 0;
            for (int j = 0; j < mas.length; j++)
                if (mas[j] == mas[i])
                    c++;
            count[i] = c;
        }
        int max = count[0];
        int maxRep = 0;
        for (int i = 1; i < count.length; i++)//ищем максимальное число повторов
            if (max < count[i]) {
                max = count[i];
                maxRep = i;
            }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max)
                if (mas[maxRep] > mas[i])
                    maxRep = i;
        }
        System.out.println("Число " + mas[maxRep] + " встречается " + max + " раз");
    }

    /**Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй
     * элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать*/
    static void task0() {
        int[] mas = {-1, 4, 177, -555, 111, 18, 22, -444, 12, 17, 54, -99, 22, 12, 14, 15, 17, 91, 112};
        System.out.println("Исходная последовательность: ");
        for (int i = 0; i < mas.length; i++)
            System.out.print(mas[i] + " ");

        int offset = 0;
        for (int i = 1; i < mas.length; i++)
            if (i < (mas.length / 2 + mas.length % 2)) {
                mas[i] = mas[i + 1 + offset];
                mas[i + 1 + offset] = 0;
                offset++;
            } else
                mas[i] = 0;


        System.out.println("\nСжатая последовательность: ");
        for (int i = 0; i < mas.length; i++)
            System.out.print(mas[i] + " ");
    }

    /*-----------------------------------------------------------------------------------------*/

    /**Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего*/
    static void task11() {
        int[][] ms = new int[5][5];
        Random r = new Random();
        for (int i = 0; i < ms.length; i++)//рандомный ввод матрицы
            for (int j = 0; j < ms[i].length; j++)
                ms[i][j] = r.nextInt(1000);

        System.out.println("Исходная матрица: ");
        for (int i = 0; i < ms.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < ms[i].length; j++)
                System.out.print(ms[i][j] + " ");
        }

        System.out.println("\n\nВсе нечетные столбцы, у которых 1 элемент > последнего: ");
        for (int i = 0; i < ms.length; i += 2) {
            if (ms[i][0] > ms[i][(ms[i].length) - 1]) {
                System.out.print("\n");
                for (int j = 0; j < ms[i].length; j++)
                    System.out.print(ms[i][j] + " ");
            }
        }
    }

    /**Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали*/
    static void task22() {
        int[][] ms = new int[5][5];
        Random r = new Random();
        for (int i = 0; i < ms.length; i++)//рандомный ввод матрицы
            for (int j = 0; j < ms[i].length; j++)
                ms[i][j] = r.nextInt(1000);

        System.out.println("Исходная матрица: ");
        for (int i = 0; i < ms.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < ms[i].length; j++)
                System.out.print(ms[i][j] + " ");
        }
        System.out.println("\n\nЭлементы матрицы по диагонали:");
        for (int i = 0; i < ms.length; i++)
            System.out.print(ms[i][i] + " ");
    }

    /**Дана матрица. Вывести k-ю строку и p-й столбец матрицы*/
    static void task33() {
        Random r = new Random();
        int[][] ms = new int[r.nextInt(8)+2][r.nextInt(8)+2];
        for (int i = 0; i < ms.length; i++)//рандомный ввод матрицы
            for (int j = 0; j < ms[i].length; j++)
                ms[i][j] = r.nextInt(1000);

        System.out.println("Исходная матрица: ");
        for (int i = 0; i < ms.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < ms[i].length; j++)
                System.out.print(ms[i][j] + " ");
        }

        System.out.println("\n\nВведите номер строки p, меньше чем "+ms.length);
        Scanner s=new Scanner(System.in);
        int row=s.nextInt();
        System.out.println("\n"+row+" строка:");
        for(int j=0;j<ms[row-1].length;j++)
            System.out.print(ms[row-1][j]+" ");

        System.out.println("\n\nВведите нромер строки p, меньше чем "+ms[0].length);
        int col=s.nextInt();
        System.out.println("\n"+col+" столбец:");
        for(int i=0;i<ms[col-1].length;i++)
            System.out.print(ms[i][col-1]+"\n");
    }

    /**Сформировать квадратную матрицу порядка n по заданному образцу(n - четное)*/
    static void task44() {
        int n = 6;
        int[][] ms = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if ((i + 2) % 2 == 0)
                    ms[i][j] = j + 1;
                else
                    ms[i][j] = n - j;
        System.out.println("Итоговая матрица: ");
        for (int i = 0; i < n; i++) {
            System.out.print("\n");
            for (int j = 0; j < n; j++)
                System.out.print(ms[i][j] + " ");
        }

    }

    /**Сформировать квадратную матрицу порядка n по заданному образцу(n - четное)*/
    static void task55() {
        int n = 8;
        int[][] ms = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if ((i + j) < n)
                    ms[i][j] = i+1;
                else
                    ms[i][j] = 0;
        System.out.println("Итоговая матрица: ");
        for (int i = 0; i < n; i++) {
            System.out.print("\n");
            for (int j = 0; j < n; j++)
                System.out.print(ms[i][j] + " ");
        }
    }

    /**Сформировать квадратную матрицу порядка n по заданному образцу(n - четное)*/
    static void task66() {
        int n = 10;
        int[][] ms = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if(i<n/2)
                    if (j < i || (n - j) <= i)
                        ms[i][j] = 0;
                    else
                        ms[i][j] = 1;
                else
                    ms[i][j]=ms[n-i-1][j];

        System.out.println("Итоговая матрица: ");
        for (int i = 0; i < n; i++) {
            System.out.print("\n");
            for (int j = 0; j < n; j++)
                System.out.print(ms[i][j] + " ");
        }
    }

    /**Сформировать квадратную матрицу порядка N по правилу ...
     * и подсчитать количество положительных элементов в ней*/
    static void task77(){
        int n = 22;
        int plus=0;
        double [][] ms = new double[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                ms[i][j] = Math.sin((i * i - j * j) / n);
                if(ms[i][j]>0)
                    plus++;
            }
        System.out.println("Число положительных элементов в матрице равно "+plus);
    }

    /**В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
     * на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
     * пользователь с клавиатуры*/
    static void task88(){
        Random r = new Random();
        int[][] ms = new int[r.nextInt(8)+2][r.nextInt(8)+2];
        for (int i = 0; i < ms.length; i++)//рандомный ввод матрицы
            for (int j = 0; j < ms[i].length; j++)
                ms[i][j] = r.nextInt(100);

        System.out.println("Исходная матрица: ");
        for (int i = 0; i < ms.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < ms[i].length; j++)
                System.out.print(ms[i][j] + "\t");
        }

        System.out.println("\n\nВведите номера столбцов которые нужно поменять местами,\nони должны быть меньше "+ms[0].length+1);
        Scanner s=new Scanner(System.in);
        int col1=s.nextInt()-1;
        int col2=s.nextInt()-1;
        int temp;
        for (int i=0;i<ms.length;i++){
            temp=ms[i][col1];
            ms[i][col1]=ms[i][col2];
            ms[i][col2]=temp;
        }

        System.out.println("Итоговая матрица: ");
        for (int i = 0; i < ms.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < ms[i].length; j++)
                System.out.print(ms[i][j] + "\t");
        }
    }

    /**Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
     столбец содержит максимальную сумму*/
    static void task99(){
        Random r = new Random();
        int[][] ms = new int[r.nextInt(8)+2][r.nextInt(8)+2];
        for (int i = 0; i < ms.length; i++)//рандомный ввод матрицы
            for (int j = 0; j < ms[i].length; j++)
                ms[i][j] = r.nextInt(100);

        System.out.println("Исходная матрица: ");
        for (int i = 0; i < ms.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < ms[i].length; j++)
                System.out.print(ms[i][j] + "\t");
        }
        int []sum=new int[ms[0].length];
        for (int j=0;j<ms[0].length;j++) {
            sum[j]=0;
            for (int i = 0; i < ms.length; i++)
                sum[j]+=ms[i][j];
        }
        System.out.print("\nСуммы столбцов:\n");
        for(int i=0;i<sum.length;i++)
            System.out.print(sum[i]+"\t");
        int ind=0;
        for(int i=1;i<sum.length;i++)
            if (sum[i]>sum[ind])
                ind=i;
        System.out.println("\nМаксимальная сумма элементов в столбцах: "+sum[ind]);

    }

    /**Найти положительные элементы главной диагонали квадратной матрицы*/
    static void task010() {
        Random r = new Random();
        int n = r.nextInt(8) + 2;
        int[][] ms = new int[n][n];
        for (int i = 0; i < ms.length; i++)//рандомный ввод матрицы
            for (int j = 0; j < ms[i].length; j++)
                ms[i][j] = r.nextInt(100)-50;

        System.out.println("Исходная матрица: ");
        for (int i = 0; i < ms.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < ms[i].length; j++)
                System.out.print(ms[i][j] + "\t");
        }
        System.out.println("\nПоложительные элементы главной диагонали матрицы: \n");
        for(int i=0;i<ms.length;i++)
            if(ms[i][i]>0)
                System.out.print(ms[i][i]+"\t");
    }

    /**Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
     * которых число 5 встречается три и более раз*/
    static void task1_11(){
        int [][] ms=new int[10][20];
        Random r = new Random();
        for (int i=0;i<ms.length;i++)
            for(int j=0;j<ms[0].length;j++)
                ms[i][j]=r.nextInt(15);

        System.out.println("Исходная матрица: ");
        for (int i = 0; i < ms.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < ms[i].length; j++)
                System.out.print(ms[i][j] + "\t");
        }

        int[] ind=new int[ms.length];
        int temp;
        for(int i=0;i<ms.length;i++) {
            temp=0;
            for (int j = 0; j < ms[0].length; j++)
                if(ms[i][j]==5)
                    temp++;
            if(temp>=3)
                ind[i]=i;
            else
                ind[i]=-1;
        }

        System.out.println("\n\nНомера строк, в которых число 5 встречается 3 и более раз:");
        for(int i=0;i<ind.length;i++)
            if(ind[i]>0)System.out.print(ind[i]+1+"\t");

    }

    /**Отсортировать строки матрицы по возрастанию и убыванию значений элементов*/
    static void task212(){
        Random r = new Random();
        int[][] ms = new int[r.nextInt(8)+2][r.nextInt(8)+2];
        for (int i = 0; i < ms.length; i++)//рандомный ввод матрицы
            for (int j = 0; j < ms[i].length; j++)
                ms[i][j] = r.nextInt(100);

        System.out.println("Исходная матрица: ");
        for (int i = 0; i < ms.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < ms[i].length; j++)
                System.out.print(ms[i][j] + "\t");
        }

        for (int i=0;i<ms.length;i++)
            for (int j=0;j<ms[i].length;j++) {
                int min=j;
                for(int k=j+1;k<ms[i].length;k++)
                    if(ms[i][k]<ms[i][min])
                        min=k;
                int temp=ms[i][j];
                ms[i][j]=ms[i][min];
                ms[i][min]=temp;
            }
        System.out.println("\n\nМатрица с отсортированными по возрастанию строками: ");
        for (int i = 0; i < ms.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < ms[i].length; j++)
                System.out.print(ms[i][j] + "\t");
        }

        for (int i=0;i<ms.length;i++)
            for (int j=0;j<ms[i].length;j++) {
                int max=j;
                for(int k=j+1;k<ms[i].length;k++)
                    if(ms[i][k]>ms[i][max])
                        max=k;
                int temp=ms[i][j];
                ms[i][j]=ms[i][max];
                ms[i][max]=temp;
            }
        System.out.println("\n\nМатрица с отсортированными по убыванию строками: ");
        for (int i = 0; i < ms.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < ms[i].length; j++)
                System.out.print(ms[i][j] + "\t");
        }
    }

    /**Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов*/
    static void task313(){
        Random r = new Random();
        int[][] ms = new int[r.nextInt(8)+2][r.nextInt(8)+2];
        for (int i = 0; i < ms.length; i++)//рандомный ввод матрицы
            for (int j = 0; j < ms[i].length; j++)
                ms[i][j] = r.nextInt(100);

        System.out.println("Исходная матрица: ");
        for (int i = 0; i < ms.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < ms[i].length; j++)
                System.out.print(ms[i][j] + "\t");
        }

        for (int j=0;j<ms[0].length;j++)
            for (int i=0;i<ms.length;i++) {
                int min=i;
                for(int k=i+1;k<ms.length;k++)
                    if(ms[k][j]<ms[min][j])
                        min=k;
                int temp=ms[i][j];
                ms[i][j]=ms[min][j];
                ms[min][j]=temp;
            }
        System.out.println("\n\nМатрица с отсортированными по возрастанию столбцами: ");
        for (int i = 0; i < ms.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < ms[i].length; j++)
                System.out.print(ms[i][j] + "\t");
        }

        for (int j=0;j<ms[0].length;j++)
            for (int i=0;i<ms.length;i++) {
                int max=i;
                for(int k=i+1;k<ms.length;k++)
                    if(ms[k][j]>ms[max][j])
                        max=k;
                int temp=ms[i][j];
                ms[i][j]=ms[max][j];
                ms[max][j]=temp;
            }
        System.out.println("\n\nМатрица с отсортированными по убыванию столбцами: ");
        for (int i = 0; i < ms.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < ms[i].length; j++)
                System.out.print(ms[i][j] + "\t");
        }
    }

    /**Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
     единиц равно номеру столбца*/
    static void task414(){
        Random r = new Random();
        int m=r.nextInt(8)+2;
        int n=r.nextInt(8)+2;
        int[][] ms = new int[m][n];
        for (int j = 0; j < ms[0].length; j++)//рандомный ввод матрицы
            for (int i = 0; i < ms.length; i++)
                if(i<=j)
                    ms[i][j]=1;
                else
                    ms[i][j]=0;

        System.out.println("Исходная матрица: ");
        for (int i = 0; i < ms.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < ms[i].length; j++)
                System.out.print(ms[i][j] + "\t");
        }


    }

    /**Найдите наибольший элемент матрицы и заменить все нечетные элементы на него*/
    static void task515(){
        Random r = new Random();
        int m=r.nextInt(8)+2;
        int n=r.nextInt(8)+2;
        int[][] ms = new int[m][n];

        for (int i = 0; i < ms.length; i++)//рандомный ввод матрицы
            for (int j = 0; j < ms[i].length; j++)
                ms[i][j] = r.nextInt(100);

        System.out.println("Исходная матрица: ");
        for (int i = 0; i < ms.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < ms[i].length; j++)
                System.out.print(ms[i][j] + "\t");
        }

        int max=ms[0][0];
        for(int i=0;i<ms.length;i++)
            for(int j=0;j<ms[i].length;j++)
                if(ms[i][j]>max)
                    max=ms[i][j];
        for(int i=0;i<ms.length;i++)
            for(int j=0;j<ms[i].length;j++)
                if((i*ms[i].length+j)%2==0)
                    ms[i][j]=max;
        System.out.println("\n\nИтоговая матрица: ");
        for (int i = 0; i < ms.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < ms[i].length; j++)
                System.out.print(ms[i][j] + "\t");
        }
    }

    /**Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная из чисел 1, 2,
     * 3,...,n^2 так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между
     * собой. Построить такой квадрат*/
    static void task616() {//метод Делаира для нечетных размеров
        System.out.println("Ведите размерность магического квадрата:");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] ms1 = new int[n][n];
        int[][] ms2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            if(i==0) {
                for (int j = 0; j < n; j++) {
                    if (j == 0)
                        ms1[i][j] = (n - 1) / 2;
                    else {
                        if (j < (n - 1) / 2 + 1)
                            ms1[i][j] = j - 1;
                        else
                            ms1[i][j] = j;
                    }
                }
            }
            else
                for (int j=0;j<n;j++){
                    if(j==0)
                        ms1[i][j]=ms1[i-1][n-1];
                    else
                        ms1[i][j]=ms1[i-1][j-1];
                }
        }

        for (int i = 0; i < n; i++) {
            if(i==0) {
                for (int j = n-1; j >=0; j--) {
                    if (j == n-1)
                        ms2[i][j] = (n - 1) / 2;
                    else {
                        if (j > (n - 1) / 2 -1)
                            ms2[i][j] = n-j-2;
                        else
                            ms2[i][j] = n-j-1;
                    }
                }
            }
            else
                for (int j=n-1;j>=0;j--){
                    if(j==n-1)
                        ms2[i][j]=ms2[i-1][0];
                    else
                        ms2[i][j]=ms2[i-1][j+1];
                }
        }

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                ms1[i][j]*=n;

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                ms2[i][j]+=1;

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                ms1[i][j]+=ms2[i][j];

        System.out.println("\n\nМагический квадрат: ");
        for (int i = 0; i < ms1.length; i++) {
            System.out.print("\n");
            for (int j = 0; j < ms1[i].length; j++)
                System.out.print(ms1[i][j] + "\t");
        }
    }

    /*----------------------------------------------------------------------------------------*/

    /**Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
     * один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
     * дополнительный массив*/
    static void task111(){
        Random r=new Random();
        int []ms1=new int[r.nextInt(5)+3];
        int []ms2=new int[r.nextInt(5)+3+ms1.length];
        for (int i=0;i<ms1.length;i++)
            ms1[i]=r.nextInt(100);
        for (int i=0;i<ms2.length-ms1.length;i++)
            ms2[i]=r.nextInt(100);
        for(int i=ms2.length-ms1.length,j=0;i<ms2.length;i++,j++)
            ms2[i]=ms1[j];
        System.out.println("Массив 1:");
        for(int i=0;i<ms1.length;i++)
            System.out.print(ms1[i]+"\t");
        System.out.println("\nМассив 2:");
        for(int i=0;i<ms2.length-ms1.length;i++)
            System.out.print(ms2[i]+"\t");
        int k=ms1.length-2;
        int old_size1= ms1.length;
        ms1=new int[ms2.length];
        for(int i=0;i<k;i++)
            ms1[i]=ms2[ms2.length-old_size1+i];
        for(int i=k,j=0;j<ms2.length-old_size1;i++,j++)
            ms1[i]=ms2[j];
        for(int i=k+ms2.length-old_size1;i<ms2.length;i++)
            ms1[i]=ms2[i];
        System.out.println("\n2 Массив между: "+k+" и "+(k+1)+" элементами 1 массива:");
        for(int i=0;i<ms1.length;i++)
            System.out.print(ms1[i]+"\t");
    }

    /**Даны две последовательности a1 <= a2 <=...<= an и b1 <= b2 <=...<= bm. Образовать из них
     * новую последовательность чисел так, чтобы она тоже была неубывающей.
     * Примечание. Дополнительный массив не использовать*/
    static void task222(){
        int []a1={1,3,5,7,9,77,78,98,1111,2222};
        int []a2={0,2,4,6,8,10,11,12,13,14,999};
        int j=0;
        System.out.println("Итоговая неубывающая последовательность: ");
        for (int i=0;i<a1.length;i++){
            if(j<a2.length) {
                if (a2[j] < a1[i]) {
                    System.out.print(a2[j] + "\t");
                    j++;
                    i--;
                }
                else
                    System.out.print(a1[i]+"\t");
            }
            else
                System.out.print(a1[i]+"\t");
        }
    }

    /**Сортировка выбором. Дана последовательность чисел a1 <= a2 <=...<= an . Требуется переставить элементы так,
     * чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший
     * элемент и ставится на первое место, а первый - на место наибольшего. Затем, начиная со второго, эта процедура
     * повторяется. Написать алгоритм сортировки выбором*/
    static void task333(){
        int max;
        int temp;
        Random r=new Random();
        int []ms=new int[r.nextInt(5)+5];
        for(int i=0;i<ms.length;i++)
            ms[i]=r.nextInt(100);
        System.out.println("Исходный массив:");
        for(int i=0;i<ms.length;i++)
            System.out.print(ms[i]+"\t");

        for(int i=0;i<ms.length;i++){
            max=i;
            for(int j=max;j<ms.length;j++)
                if(ms[j]>ms[max])
                    max=j;
            if(max!=i){
                temp=ms[i];
                ms[i]=ms[max];
                ms[max]=temp;
            }
        }
        System.out.println("\nСортировка по убыванию:");
        for(int i=0;i<ms.length;i++)
            System.out.print(ms[i]+"\t");
    }

    /**Сортировка обменами. Дана последовательность чисел a1 <= a2 <=...<= an .Требуется переставить числа в
     * порядке возрастания. Для этого сравниваются два соседних числа ai и ai+1 . Если ai > ai+1 , то делается
     * перестановка. Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
     * Составить алгоритм сортировки, подсчитывая при этом количества перестановок*/
    static void task444(){
        int min;
        int temp;
        int flag=1;
        int count=0;
        Random r=new Random();
        int []ms=new int[r.nextInt(5)+5];
        for(int i=0;i<ms.length;i++)
            ms[i]=r.nextInt(100);
        System.out.println("Исходный массив:");
        for(int i=0;i<ms.length;i++)
            System.out.print(ms[i]+"\t");

        while(flag!=0){
            flag=0;
            for(int i=0;i<ms.length-1;i++)
                if(ms[i+1]<ms[i]){
                    temp=ms[i];
                    ms[i]=ms[i+1];
                    ms[i+1]=temp;
                    flag=1;
                    count++;
                }
        }
        System.out.println("\nСортировка по возрастанию, количество перестановок "+count+":");
        for(int i=0;i<ms.length;i++)
            System.out.print(ms[i]+"\t");
    }

    /**Сортировка вставками. Дана последовательность чисел a1,a2,...,an . Требуется переставить числа в порядке
     возрастания. Делается это следующим образом. Пусть a1,a2,...,ai - упорядоченная последовательность, т. е.
     a1 <= a2 <=...<= an . Берется следующее число ai+1 и вставляется в последовательность так, чтобы новая
     последовательность была тоже возрастающей. Процесс производится до тех пор, пока все элементы от i +1 до n
     не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить
     с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции*/
    static void task555(){
        int max;
        int temp;
        Random r=new Random();
        int []ms=new int[r.nextInt(5)+5];
        for(int i=0;i<ms.length;i++)
            ms[i]=r.nextInt(100);
        System.out.println("Исходный массив:");
        for(int i=0;i<ms.length;i++)
            System.out.print(ms[i]+"\t");

        for(int i=0;i<ms.length-1;i++){
            if(ms[i+1]<ms[i]){
                int ind=binSearch(ms,i+1);
                temp=ms[i+1];
                for(int j=i+1;j>ind;j--) {
                    ms[j] = ms[j - 1];
                }
                ms[ind] = temp;
            }
        }

        System.out.println("\nИтоговый массив:");
        for(int i=0;i<ms.length;i++)
            System.out.print(ms[i]+"\t");
    }


    /**бинарный поиск для сортировки вставками*/
    static private int binSearch(int[] a, int ind) {
        int l = -1;                      // l, r — левая и правая границы
        int r = ind;
        while (l<r -1) {                // Запускаем цикл
            int m = (l + r) / 2;            // m — середина области поиска
            if (a[m] < a[ind])
            l = m;
        else
            r = m;                  // Сужение границ
        }
        return r;
    }

    /**Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
     * Делается это следующим образом: сравниваются два соседних элемента ai и ai+1 . Если ai <= ai+1 , то продвигаются
     * на один элемент вперед. Если ai > ai+1 , то производится перестановка и сдвигаются на один элемент назад.
     * Составить алгоритм этой сортировки*/
    static void task666(){
        Random r=new Random();
        int temp;
        int []ms=new int[r.nextInt(5)+5];
        for(int i=0;i<ms.length;i++)
            ms[i]=r.nextInt(100);
        System.out.println("Исходный массив:");
        for(int i=0;i<ms.length;i++)
            System.out.print(ms[i]+"\t");

        for(int i=0;i<ms.length-1;i++){
            if(ms[i]<ms[i+1])
                continue;
            else {
                temp=ms[i];
                ms[i]=ms[i+1];
                ms[i+1]=temp;
                i=-1;
            }
        }

        System.out.println("\nСортировка Шелла по возрастанию:");
        for(int i=0;i<ms.length;i++)
            System.out.print(ms[i]+"\t");

    }

    /**Пусть даны две неубывающие последовательности действительных чисел a1 <= a2 <=...<= an и b1 <= b2 <=...<= bm .
     * Требуется указать те места, на которые нужно вставлять элементы последовательности b1 <= b2 <=...<= bm в первую
     * последовательность так, чтобы новая последовательность оставалась возрастающей*/
    static void task777() {
        Random r = new Random();
        int[] b = new int[r.nextInt(5) + 2];
        int[] a = new int[r.nextInt(3) + b.length + 1];
        for (int i = 0; i < a.length; i++)//рандомно заполняем массивы по возрастанию
            if (i == 0)
                a[i] = r.nextInt(100);
            else
                a[i] = r.nextInt(100) + a[i - 1];
        for (int i = 0; i < b.length; i++)
            if (i == 0)
                b[i] = r.nextInt(100);
            else
                b[i] = r.nextInt(100) + b[i - 1];

        System.out.println("Первая последовательность:");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + "\t");
        System.out.println("\nВторая последовательность:");
        for (int i = 0; i < b.length; i++)
            System.out.print(b[i] + "\t");

        int j = 0;
        int[] ind = new int[b.length];

        for (int i = 0; i < a.length; i++) {
            if (j < b.length) {
                if (b[j] < a[i]) {
                    ind[j]=i;
                    j++;
                    i--;
                }
            }
        }

        System.out.println("\nМеста вставки элементов второй последовательности в первую:");
        for (int i = 0; i < ind.length; i++)
            System.out.print((ind[i]+1) + "\t");
    }

    /**Даны дроби pi/qi ( pi, qi - натуральные). Составить программу, которая приводит эти дроби к общему
     знаменателю и упорядочивает их в порядке возрастания*/
    static void task888(){
        int n=5;
        int[]p=new int[n];
        int []q=new int[n];
        Random r=new Random();
        for(int i=0;i<n;i++){
            p[i]=r.nextInt(8)+1;
            q[i]=r.nextInt(8)+1;
        }

        System.out.println("Имеем "+n+" дроби: ");
        for(int i=0;i<n;i++){
            System.out.print(p[i]+"\\"+q[i]+"\t");
        }

        int[]reserveP=new int[n];
        System.arraycopy(p,0,reserveP,0,n);
        int[]reserveQ=new int[n];
        System.arraycopy(q,0,reserveQ,0,n);
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(j!=i) {
                    p[i] *= reserveQ[j];
                    q[i] *= reserveQ[j];
                }

        System.out.println("\nИмеем "+n+" дроби c общим знаменателем: ");
        for(int i=0;i<n;i++)
            System.out.print(p[i]+"\\"+q[i]+"\t");

        int min;
        int temp;
        for(int i=0;i<n;i++){
            min=i;
            for(int j=min;j<n;j++)
                if(p[j]<p[min])
                    min=j;
            if(i!=min){
                temp=p[i];
                p[i]=p[min];
                p[min]=temp;
            }
        }

        System.out.println("\nСортировка по возрастанию дробей c общим знаменателем: ");
        for(int i=0;i<n;i++)
            System.out.print(p[i]+"\\"+q[i]+"\t");
    }

    /*-----------------------------------------------------------------------------------------*/

    /**Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
     натуральных чисел*/
    static void task1111(){
        Random r=new Random();
        int A=r.nextInt(100)+1;
        int B=r.nextInt(100)+1;
        System.out.println("Даны числа: "+A+" и "+B);
        System.out.println("Их НОД равен "+NOD(A,B));
        System.out.println("Их НОК равно "+NOK(A,B));
    }

    /**НОД 2 чисел*/
    static private int NOD(int A, int B){
        int []dA=massiveD(A);
        int []dB=massiveD(B);

        for(int i=dB.length-1;i>=0;i--)
            for(int j=dA.length-1;j>=0;j--)
                if(dA[j]==dB[i])
                    return dB[i];
        return 1;
    }

    /**НОК двух чисел*/
    static private int NOK(int A, int B){
        return A*B/NOD(A,B);
    }


    /**Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел*/
    static void task2222(){
        Random r=new Random();
        int A=r.nextInt(100)+1;
        int B=r.nextInt(100)+1;
        int C=r.nextInt(100)+1;
        int D=r.nextInt(100)+1;
        System.out.println("Даны числа: "+A+", "+B+", "+C+" и "+D);
        System.out.println("Их НОД равен "+NOD(A,B,C,D));
    }

    /**НОД 4 чисел*/
    static private int NOD(int A, int B, int C, int D){
        int []dA=massiveD(A);
        int []dB=massiveD(B);
        int []dC=massiveD(C);
        int []dD=massiveD(D);
        for(int i=dA.length-1;i>=0;i--)
            for(int j=dB.length-1;j>=0;j--)
                if(dA[i]==dB[j])
                    for(int k=dC.length-1;k>=0;k--)
                        if(dA[i]==dC[k])
                            for(int l=dD.length-1;l>=0;l--)
                                if(dA[i]==dD[l])
                                    return dA[i];
        return 1;
    }

    /**вовзращает количество делителей*/
    static private int numberD(int A){
        int flag=0;
        for(int i=1;i<=A;i++)
            if(A%i==0)
                flag++;
        return flag;
    }

    /**возвращает массив делителей*/
    static private int[] massiveD(int A){
        int d=numberD(A);
        int []temp=new int[d];
        int j=0;
        for(int i=1;i<=A;i++)
            if(A%i==0)
                temp[j++]=i;
        return temp;
    }


    /**Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади
     треугольника*/
    static void task3333(){
        Random r=new Random();
        int a=r.nextInt(10)+1;
        System.out.println("Площадь правильного шестиугольника со стороной  "+a+" равна: "+RegTriangleSquare(a)*6);
    }

    /**площадь правильного треугольника*/
    static private double RegTriangleSquare(int a){
        return Math.sqrt(3)/4*Math.pow(a,2);
    }


    /**На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими
     * из пар точек самое большое расстояние. Указание. Координаты точек занести в массив*/
    static void task4444(){
        Random r=new Random();
        int n=r.nextInt(3)+5;
        Point []p=new Point[n];
        for(int i=0;i<n;i++){
            p[i]=new Point();
            p[i].x=r.nextInt(25);
            p[i].y=r.nextInt(25);
        }

        System.out.println("Даны точки:");
        for (Point el:p
             ) {
            System.out.println(el.x+";"+el.y+"\t");
        }

        int []res=MaxPointDistance(p);

        System.out.println("Максимальное расстояние между точками "+p[res[0]].x+";"+p[res[0]].y+" и "+p[res[1]].x+";"+p[res[1]].y);
    }

    /**ищет макс расстояние в массиве точек*/
    static private int [] MaxPointDistance(Point[] p){
        int []res=new int[2];
        double dist;
        double maxdist=0;
        for(int i=0;i<p.length-1;i++) {
            for (int j = i + 1; j < p.length; j++){
                dist=PointDistance(p[j],p[i]);
                if(dist>maxdist) {
                    res[0]=i;
                    res[1]=j;
                    maxdist=dist;
                }
            }
        }
        return res;
    }

    /**расстояние между 2 точками*/
    static private double PointDistance(Point p1, Point p2){
        return Math.sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));
    }


    /**Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
     * которое меньше максимального элемента массива, но больше всех других элементов)*/
    static void task5555(){
        Random r=new Random();
        int n=r.nextInt(5)+5;
        int[]ms=new int[n];
        for(int i=0;i<n;i++)
            ms[i]=r.nextInt(100);
        System.out.println("Задан массив значений:");
        for (int el:ms
             ) {
            System.out.print(el+"\t");
        }
        SortDown(ms);
        System.out.println("\nВторое по величине значение: "+ms[1]);
    }

    /**сортировка выбором по убыванию*/
    static private void SortDown(int []ms){
        int temp;
        int max;
        for(int i=0;i<ms.length;i++){
            max=i;
            for(int j=max;j<ms.length;j++)
                if(ms[j]>ms[max])
                    max=j;
            if(i!=max)
                Swap(ms,max,i);
        }
    }

    /**свап 2 элементов в массиве*/
    static private void Swap(int []ms, int i, int j){
        int temp=ms[i];
        ms[i]=ms[j];
        ms[j]=temp;
    }


    /**Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми*/
    static void task6666(){
        Random r=new Random();
        int a=r.nextInt(99)+1;
        int b=r.nextInt(99)+1;
        int c=r.nextInt(99)+1;
        System.out.print("Числа "+a+" "+b+" "+c);
        if(IsSimpleABC(a,b,c)==true)
            System.out.print(" являются взаимно простыми");
        else
            System.out.print(" не являются взаимно простыми");
    }

    /**метод проверки на взаимную простоту*/
    static private boolean IsSimpleABC(int A, int B, int C){
        int []dA=massiveD(A);
        int []dB=massiveD(B);
        int []dC=massiveD(C);
        for(int i=dA.length-1;i>=0;i--)
            for(int j=dB.length-1;j>=0;j--)
                if(dA[i]==dB[j])
                    for(int k=dC.length-1;k>=0;k--)
                        if(dA[i]==dC[k])
                            if(dA[i]!=1)
                                return false;
        return true;
    }


    /**Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9*/
    static void task7777(){
        int start=1;
        int end=9;
        int step=2;
        System.out.println("Сумма факториалов всех нечетных чисел от "+start+" до "+end+" равна "+SumFactStep(start,end,step));
    }

    /**метод суммы факторилов чисел*/
    static private long SumFactStep(int start, int end, int step){
        long sum=0;
        for(int i=start;i<end;i+=step)
            sum+=Fact(i);
        return sum;
    }

    /**факториал числа*/
    static private int Fact(int a){
        int res=1;
        for(int i=2;i<=a;i++)
            res*=i;
        return res;
    }


    /** Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
     * Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов
     * массива с номерами от k до m*/
    static void task8888(){
        Random r=new Random();
        int n=6;
        int ms[]=new int[n];
        for(int i=0;i<n;i++)
            ms[i]=r.nextInt(20);
        for(int i=0;i<n;i++)
            System.out.print(ms[i]+"\t");
        System.out.println("\nСумма элементов с 1 по 3 равна "+Sum3(ms,0,2));
        System.out.println("\nСумма элементов с 3 по 5 равна "+Sum3(ms,2,4));
        System.out.println("\nСумма элементов с 4 по 6 равна "+Sum3(ms,3,5));
    }

    /**сумма элементов в массиве*/
    static private int Sum3(int []ms, int i, int j){
        int sum=0;
        for(int l=i;l<=j;l++)
            sum+=ms[l];
        return sum;
    }


    /**Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади,
     если угол между сторонами длиной X и Y— прямой*/
    static void task9999(){
        Random r=new Random();
        double x=r.nextInt(10)+1;
        double y=r.nextInt(10)+1;
        double z=r.nextInt(10)+1;
        double t=r.nextInt(10)+1;
        double hyp=Math.sqrt((x*x)+(y*y));
        double s=TriangleSquare(x,y,hyp);
        s+=TriangleSquare(hyp,z,t);
        System.out.println("Площадь 4-угольника со сторонами "+x+" "+y+" "+z+" "+t+" равна "+s);
    }

    /**площадь треугольника по 3 сторонам (формула Герона)*/
    static private double TriangleSquare(double a, double b, double c){
        double p=(a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }


    /**Дано натуральное число N. Написать метод(методы) для формирования массива, элементами которого
     являются цифры числа N*/
    static void task0101010(){
        int n=1234111;
        int []d=MsDigits(n);
        for (int el:d
             ) {
            System.out.print(el+"\t");
        }
    }

    /**метод возвращает массив с цифрами числа n*/
    static private int[] MsDigits(int n){
        int []res;
        char []ch=String.valueOf(n).toCharArray();
        res=new int[ch.length];
        for(int i=0;i<ch.length;i++)
            res[i]=Character.getNumericValue(ch[i]);
        return res;
    }


    /**Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр*/
    static void task1_11_11_11(){
        Random r=new Random();
        int a=r.nextInt(99999);
        int b=r.nextInt(99999);
        System.out.println("Даны числа "+a+" "+b);
        int res=MoreDigits(a,b);
        if(res==-1)
            System.out.println("В цифрах "+a+" и "+b+" цифр одинаково");
        else
            System.out.println("Цифр больше в числе "+res);
    }

    /**метод возвращает число с большим количеством цифр*/
    static private int MoreDigits(int a, int b){
        if(MsDigits(a).length>MsDigits(b).length)
            return a;
        if(MsDigits(a).length<MsDigits(b).length)
            return b;
        return -1;
    }


    /**Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого
     являются числа, сумма цифр которых равна К и которые не большее N*/
    static void task2121212(){
        Random r=new Random();
        int k=r.nextInt(17)+1;
        int n=r.nextInt(100)+1+k;
        int []ms=ReturnMsA(k,n);
        System.out.println("Дано: k="+k+"; n="+n);
        System.out.println("Чиcла, сумма цифр которых равна k, но которые не больше n:");
        for (int i=0;i<ms.length;i++)
            System.out.print(ms[i]+"\t");
    }

    /**метод возвращает массив чисел, сумма цифр которых равно k, но не больше n*/
    static private int[] ReturnMsA(int k,int n){
        int size= MsSize(k,n);
        int []ms=new int[size];
        int []temp;
        int sum;
        int l=0;
        for(int i=0;i<n;i++){
            if(CaseOfSumEqualToK(i+1,k)==true)
                ms[l++]=i+1;
        }
        return ms;
    }

    /**вычисляем размер возвращаемого массива для функции returnMsA*/
    static private int MsSize(int k, int n){
        int []temp;
        int sum;
        int count=0;
        for(int i=0;i<n;i++){//вычисляем размер массива, который будем возвращать
            if(CaseOfSumEqualToK(i+1,k)==true)
                count++;
        }
        return count;
    }

    /**проверка, если сумма цифр в числе равна k и меньше n*/
    static private boolean CaseOfSumEqualToK(int n, int k){
        int []temp;
        int sum;
        temp=MsDigits(n);//для каждого числа, меньше чем n, возвращаем массив цифр
        sum=0;
        for(int j=0;j<temp.length;j++)
            sum+=temp[j];
        if(sum==k)
            return true;
        else
            return false;
    }


    /**Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
     * Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. Для
     * решения задачи использовать декомпозицию*/
    static void task3131313(){
        Random r=new Random();
        int n=r.nextInt(100)+2;
        int []ms=SimpleTwins(n);
        System.out.println("Простые близнецы на отрезке ["+n+";"+2*n+"]:");
        for(int i=0;i<ms.length-1;i+=2)
            System.out.print(ms[i]+";"+ms[i+1]+"\t");
    }

    /**возвращает массив простых близнецов на отрезке [n;2n]*/
    static private int[] SimpleTwins(int n){
        int []msSimple=SimpleMassive(n,2*n);
        int size=SizeOfSimpleTwinsMassive(msSimple);
        int []msTwins=new int[size];
        int j=0;
        for(int i=0;i<msSimple.length-1;i++)
            if(msSimple[i]==msSimple[i+1]-2) {
                msTwins[j] = msSimple[i];
                msTwins[j+1]=msSimple[i+1];
                j+=2;
            }
        return msTwins;
    }

    /**возвращает массив простых чисел на отрезке*/
    static private int[] SimpleMassive(int n, int n2) {
        int size=SizeOfSimpleMassive(n,n2);
        int []ms=new int[size];
        int j=0;
        for(int i=n;i<=n2;i++)
            if(IsSimple(i)==true)
                ms[j++]=i;
        return ms;
    }

    /**подсчет количества простых чисел на отрезке*/
    static private int SizeOfSimpleMassive(int n, int n2){
        int count = 0;
        for(int i=n;i<=n2;i++)
            if(IsSimple(i)==true)
                count++;
        return count;
    }

    /**проверка числа на простоту*/
    static private boolean IsSimple(int n){
        int count=0;
        int flag;
        int temp[]=massiveD(n);
        if(temp.length==1)
            return true;
        if(temp[0]==1 && temp[1]==n)
            return true;
        return false;
    }

    /**подсчет количества пар близнецов*/
    static private int SizeOfSimpleTwinsMassive (int []ms){
        int count=0;
        for(int i=0;i<ms.length-1;i++)
            if(ms[i]==ms[i+1]-2)
                count+=2;
        return count;
    }


    /**Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
     * возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи
     * использовать декомпозицию*/
    static void task4141414(){
        int k=10000;
        int []ms=MasArmstrong(k);
        System.out.println("Все числа Армстронга на отрезке от 1 до "+k+":");
        for(int i=0;i<ms.length;i++)
            System.out.print(ms[i]+"\t");
    }

    /**возвращает массив чисел Армстронга от 1 до k*/
    static private int [] MasArmstrong(int k){
        int size=SizeofMasArmstrong(k);
        int []ms=new int[size];
        int l=0;
        for(int i=1;i<=k;i++){
            if(CaseOfArmstrong(i)==true)
                ms[l++]=i;
        }

        return ms;
    }

    /**считает количество чисел Армстронга от 1 до k*/
    static private int SizeofMasArmstrong(int k){
        int flag=0;
        for(int i=1;i<=k;i++){
            if(CaseOfArmstrong(i)==true)
                flag++;
        }
        return flag;
    }

    /**если число является числом Армстронга*/
    static private boolean CaseOfArmstrong(int k){
        int []temp;
        int sum;
        temp=MsDigits(k);
        sum=0;
        for(int j=0;j<temp.length;j++)
            sum+=Math.pow(temp[j],temp.length);
        if(sum==k)
            return true;
        else
            return false;
    }


    /**Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую
     *последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию*/
    static void task5151515(){
        int n=4;
        System.out.println("Все "+n+"-значные числа, цифры которых стоят по возрастанию: ");
        int []ms=MasOfIncreasingNumbers(n);
        for(int i=0;i<ms.length;i++)
            System.out.print(ms[i]+"\t");
    }

    /**возвращает массив с числами, у которых цифры стоят по возрастанию*/
    static private int[] MasOfIncreasingNumbers(int n){
        int num=(int)Math.pow(10,n);
        int size=SizeOfMasOfIncreasingNumbers(n);
        int []ms=new int[size];
        int l=0;
        for(int i=(int)Math.pow(10,n-1);i<=num;i++){
            if(CaseOfIncNum(i)==true)
                ms[l++]=i;
        }
        return ms;
    }

    /**подсчет количества чисел с возрастающими цифрами*/
    static private int SizeOfMasOfIncreasingNumbers(int n){
        int count=0;
        int num=(int)Math.pow(10,n);
        for(int i=(int)Math.pow(10,n-1);i<=num;i++){
            if(CaseOfIncNum(i)==true)
                count++;
        }
        return count;
    }

    /**проверка на возрастание цифр в числе*/
    static private boolean CaseOfIncNum(int num){
        int []temp=MsDigits(num);
        int flag=1;
        for(int j=0;j<temp.length-1;j++)
            if(temp[j]>=temp[j+1])
                flag=0;
        if(flag==1)
            return true;
        else
            return false;
    }


    /**Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
     * Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию*/
    static void task6161616(){
        int n=3;
        int []ms=OddMas(n);
        System.out.println(n+"-значные числа с нечетными цифрами: ");
        for (int i=0;i<ms.length;i++)
            System.out.print(ms[i]+"\t");
        int sum=SumOfOddMas(n);
        System.out.println("\nИх сумма: "+sum);
        System.out.println("\nКоличество четных числе в этой сумме: "+DefineEven(sum));
    }

    /**сумма числе в массиве*/
    static private int SumOfOddMas(int n){
        int []ms=OddMas(n);
        int sum=0;
        for(int i=0;i<ms.length;i++)
            sum+=ms[i];
        return sum;
    }

    /**возращает массив с числами, у которых нечетные цифры*/
    static private int[] OddMas(int n){
        int num=(int)Math.pow(10,n);
        int size=SizeOfOddMas(n);
        int []ms=new int[size];
        int l=0;
        for(int i=(int)Math.pow(10,n-1);i<=num;i++)
            if(CaseOfOddDigits(i)==true)
                ms[l++]=i;
        return ms;
    }

    /**подсчет количества чисел с нечетными цифрами*/
    static private int SizeOfOddMas(int n) {
        int num=(int)Math.pow(10,n);
        int count=0;
        for(int i=(int)Math.pow(10,n-1);i<=num;i++)
            if(CaseOfOddDigits(i)==true)
                count++;
        return count;
    }

    /**проверка на нечетность цифр в числе*/
    static private boolean CaseOfOddDigits(int num){
        int []temp=MsDigits(num);
        int flag=1;
        for(int j=0;j<temp.length;j++)
            if(temp[j]%2==0){
                flag=0;
                break;
            }
        if(flag==1)
            return true;
        else
            return false;
    }

    /**подсчет количества четных цифр в числе*/
    static private int DefineEven(int k){
        int []temp=MsDigits(k);
        int count=0;
        for(int i=0;i<temp.length;i++)
            if(temp[i]%2==0)
                count++;
        return count;
    }


    /**Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. Сколько таких
     * действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию*/
    static void task7171717(){
        Random r=new Random();
        int num=r.nextInt(100)+19;
        int count=NumberOfRotations(num);
        System.out.println("Для числа "+num+" нужно "+count+" вычитаний суммы его цифр, чтобы получить 0");

    }

    /**возвращает число-сумма его цифр*/
    static private int NumberMinusSumOfDigits(int num){
        return num-SumOfDigits(num);
    }

    /**подсчет количества необходимых действий с числом*/
    static private int NumberOfRotations(int num){
        int res=num;
        int count=0;
        while(res!=0){
            if(res<0)
                return -1;
            res=NumberMinusSumOfDigits(res);
            count++;
        }
        return count;
    }

    /**возвращает сумму цифр в числе*/
    static private int SumOfDigits(int num){
        int []temp=MsDigits(num);
        int sum=0;
        for (int el:temp
             ) {
            sum+=el;
        }
        return sum;
    }
}
