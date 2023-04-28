package com.haemimont.carsapp.core.tools;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ListTools {
    public static List<List> ListSpreader(List finalList, int cntOfLists) {
        List list = finalList;
        int size = list.size();
        List listOfLists = new ArrayList<>();
        int currentIndex=0;
       for(int i=0;i<cntOfLists;i++){
           List partialList = new ArrayList();
           for(int n =0;n<size/cntOfLists;n++){
               if(list.isEmpty()){break;
               }else {
               partialList.add(list.get(currentIndex));
               currentIndex++;}
           }if (i == (cntOfLists - 1)) {
               while (currentIndex!=size) {
                   partialList.add(list.get(currentIndex));
                   currentIndex++;
               }
           } listOfLists.add(partialList);
       }
       return listOfLists;

    }
}
