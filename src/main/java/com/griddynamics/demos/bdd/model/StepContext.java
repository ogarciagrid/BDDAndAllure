package com.griddynamics.demos.bdd.model;

import com.griddynamics.qa.sprimber.engine.scope.annotation.ScenarioComponent;

@ScenarioComponent
public class StepContext {
    private Integer value;

    public Integer getValue() {return value;}

    public void setValue(Integer value){this.value=value;}
}
