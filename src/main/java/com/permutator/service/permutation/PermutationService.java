package com.permutator.service.permutation;

import com.permutator.model.entity.Job;

import java.util.Set;

public interface PermutationService {

    Set<String> getPermutations(Job job);

    void permute(String prefix, String s, int length);

    Set<String> getStringBySpecificData(Job job);
}
