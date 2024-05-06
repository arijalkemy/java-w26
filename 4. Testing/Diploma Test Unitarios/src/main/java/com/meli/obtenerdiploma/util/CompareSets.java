package com.meli.obtenerdiploma.util;

import com.meli.obtenerdiploma.model.StudentDTO;

import java.util.*;

public class CompareSets {

    public static boolean compare(Set<StudentDTO> set1, Set<StudentDTO> set2) {
        List<StudentDTO> list1 = new ArrayList<>(set1);
        List<StudentDTO> list2 = new ArrayList<>(set2);
        list1.sort(Comparator.comparing(StudentDTO::getId));
        list2.sort(Comparator.comparing(StudentDTO::getId));
        if (set1.size() != set2.size()) return false;
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).getStudentName().equals(list2.get(i).getStudentName()) ||
                    !list1.get(i).getId().equals(list2.get(i).getId()) ||
                    !list1.get(i).getMessage().equals(list2.get(i).getMessage()) ||
                    !list1.get(i).getAverageScore().equals(list2.get(i).getAverageScore()) ||
                    !list1.get(i).getSubjects().equals(list2.get(i).getSubjects())
            ) return false;
        }
        return true;
    }
}
