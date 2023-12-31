package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double score = 0;
        int counter = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                counter++;
            }
        }
        return score / counter;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            int counter = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                counter++;
            }
            list.add(new Label(pupil.name(), score / counter));
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Double> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), (double) subject.score(), (oldValue, newValue) -> oldValue + subject.score());
            }
        }
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            list.add(new Label(entry.getKey(), entry.getValue() / pupils.size()));
        }
        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            list.add(new Label(pupil.name(), score));
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Double> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), (double) subject.score(), (oldValue, newValue) -> oldValue + subject.score());
            }
        }
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            list.add(new Label(entry.getKey(), entry.getValue()));
        }
        Label max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (max.score() < list.get(i).score()) {
                max = list.get(i);
            }
        }
        return max;
    }
}
