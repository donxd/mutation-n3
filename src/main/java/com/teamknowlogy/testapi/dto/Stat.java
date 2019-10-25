package com.teamknowlogy.testapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stat {
    @JsonProperty("count_mutations")
    private int countMutations;
    @JsonProperty("count_no_mutation")
    private int countNoMutation;
    @JsonProperty("ratio")
    private float ratio;

    public Stat () {
    }

    public Stat (int countMutations, int countNoMutation, float ratio) {
        this.countMutations = countMutations;
        this.countNoMutation = countNoMutation;
        this.ratio = ratio;
    }

    public int getCountMutations () {
        return countMutations;
    }

    public void setCountMutations (int countMutations) {
        this.countMutations = countMutations;
    }

    public int getCountNoMutation () {
        return countNoMutation;
    }

    public void setCountNoMutation (int countNoMutation) {
        this.countNoMutation = countNoMutation;
    }

    public float getRatio () {
        return ratio;
    }

    public void setRatio (float ratio) {
        this.ratio = ratio;
    }
}