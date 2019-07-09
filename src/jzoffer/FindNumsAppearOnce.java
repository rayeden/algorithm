package jzoffer;

/**
 * @author Sesame
 * @createTime 2019/6/28
 * @description
 */
public class FindNumsAppearOnce {

    public static void main(String[] args) {
        FindNumsAppearOnce fn = new FindNumsAppearOnce();
        int[] num1 = {0};
        int[] num2 = {0};
        int[] array = {1, 1, 3, 6};
        fn.findNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

    public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int xor = 0;
        for(int i = 0; i < array.length; i++){
            xor ^= array[i];
        }
        int tmp = 1;
        while((xor & tmp) == 0){
            tmp <<= 1;
        }
        for(int i = 0; i < array.length; i++){
            if((tmp & array[i]) == 0){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }
}
