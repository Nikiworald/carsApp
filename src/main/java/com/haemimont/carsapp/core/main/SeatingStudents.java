package com.haemimont.carsapp.core.main;

public class SeatingStudents {
    public int SeatingStudents(int[] arr) {
        int cnt = 0;
        int numberOfDesks = arr[0];
        for (int i = 1; i < numberOfDesks; i++) {
            if (!checkIfNumberIsInArr(arr, i)) {
                if (i % 2 != 0) {
                    if (!checkIfNumberIsInArr(arr, i + 1)) {
                        cnt++;
                    }

                }
                if (!checkIfNumberIsInArr(arr, i + 2) && i + 2 <= numberOfDesks) {
                    cnt++;
                }
            }

        }


        return cnt;
    }

    public boolean checkIfNumberIsInArr(int[] arr, int number) {
        boolean check = false;
        for(int i=0;i<arr.length;i++){
            if(i>0){
                if (arr[i]==number){
                    check=true;
                    break;
                }
            }
        }
        return check;

    }

}
