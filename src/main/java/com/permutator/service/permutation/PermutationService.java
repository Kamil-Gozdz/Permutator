package com.permutator.service.permutation;

import com.permutator.model.entity.Job;

import java.util.List;

public interface PermutationService {

    List<String> getPermutations(Job job);

    void permute(String prefix, String s, int length);

    List<String> getStringBySpecificData(Job job);
}
