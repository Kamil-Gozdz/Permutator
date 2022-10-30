package com.permutator.service.permutation;


import com.permutator.model.entity.Job;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class PermutationServiceImpl implements PermutationService {
    private final List<String> permutations;



    @Override
    public List<String> getPermutations(Job job) {
        for (int j = 1; j <= job.getLetters().length(); j++) {
            permute("", job.getLetters(), j);
        }
        return permutations;
    }


    @Override
    public void permute(String prefix, String s, int length) {
        String word;
        for (int i = 0; i < s.length(); i++) {
            word = prefix + s.charAt(i);
            if (word.length() == length) {
                permutations.add(word);
            } else {
                if (i == 0) {
                    permute(word, s.substring(i + 1), length);
                } else if (i == (s.length() - 1)) {
                    permute(word, s.substring(0, s.length() - 1), length);
                } else {
                    permute(word, (s.substring(0, i) + s.substring(i + 1)), length);
                }
            }
        }
    }

    @Override
    public List<String> getStringBySpecificData(Job job) {
        List<String> strings = getPermutations(job);
        return strings.stream()
                .filter(p -> (p.length() <= job.getMaxLength()))
                .filter(p -> (p.length() >= job.getMinLength()))
                .limit(job.getStringAmount())
                .collect(Collectors.toList());
    }
}
