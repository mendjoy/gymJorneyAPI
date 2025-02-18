package io.github.mendjoy.gymJourneyAPI.dto.exercise;

public class ExerciseDTO {

    private Integer id;
    private String name;
    private String description;
    private String muscle_group;

    public ExerciseDTO() {
    }

    public ExerciseDTO(Integer id, String name, String description, String muscle_group) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.muscle_group = muscle_group;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMuscle_group() {
        return muscle_group;
    }

    public void setMuscle_group(String muscle_group) {
        this.muscle_group = muscle_group;
    }
}
