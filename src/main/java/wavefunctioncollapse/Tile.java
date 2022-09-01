package wavefunctioncollapse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Tile {
    private final Set<Integer> allNumbers;
    private Set<Integer> possibleNumbers;
    private Integer choice;
    private boolean isCollapsed = false;

    public Tile(int choice){
        Set<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        integers.add(9);

        allNumbers = integers;
        possibleNumbers = integers;

        this.choice = choice;
        if(choice!=0){
            isCollapsed = true;
            possibleNumbers = possibleNumbers.stream().filter( n -> n==choice).collect(Collectors.toSet());
        }
    }

    public Set<Integer> getAllNumbers() {
        return allNumbers;
    }

    public Set<Integer> getPossibleNumbers() {
        return possibleNumbers;
    }

    public int getChoice() {
        return choice;

    }

    public boolean isCollapsed() {
        return isCollapsed;
    }

    public void setChoice(int choice) {
        this.choice = choice;
        setCollapsed(true);
    }

    public void setCollapsed(boolean collapsed) {
        isCollapsed = collapsed;
    }

    public void limitPossibleNumbers(Integer i){
        possibleNumbers.remove(i);
    }
}
