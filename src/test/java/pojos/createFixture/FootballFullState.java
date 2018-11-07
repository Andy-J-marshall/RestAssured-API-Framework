package pojos.createFixture;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
@Setter
public class FootballFullState {
    private String period;
    private List<Team> teams;
    private String awayTeam;
    private Boolean finished;
    private Boolean started;
    private List<Object> redCards;
    private List<Object> possibles;
    private Integer gameTimeInSeconds;
    private List<Object> corners;
    private String startDateTime;
    private String homeTeam;
    private List<Object> yellowCards;
    private List<Goal> goals;
}