package messingAround;

public class TuringMachine {
    String tape;
    //Infinite tape is 'pre-filled' with 0's
    String[] rules;
    //Rules will be in the format [WRITE if 0] [MOVE if 0] [NEXT STATE if 0] [WRITE if 1] [MOVE if 1] [NEXT STATE if 1]
    int headIndex;
    int currentState;
    public TuringMachine(String initialTape, String[] rules, int initialHeadIndex){
        this.tape = initialTape;
        this.rules = rules;
        if(rules.length == 0){
            throw new IllegalArgumentException("Rules array must not be empty");
        }
        currentState = 0;
        if(initialHeadIndex >= 0 && initialHeadIndex < initialTape.length()){
            headIndex = initialHeadIndex;
        } else{
            throw new IllegalArgumentException("Initial Tape must be big enough to contain initial head index.");
        }
    }

    public void run(){
        String num = tape.substring(headIndex, headIndex + 1);
        String[] ruleSplit = rules[currentState].split(" "); //Splits 1 1 1 0 0 0 into array
        if(num.equals("0")){
            StringBuilder newTape = new StringBuilder(tape);
            newTape.setCharAt(headIndex, ruleSplit[0].toCharArray()[0]);
            tape = newTape.toString();

            headIndex = (ruleSplit[1].equals("L"))?(headIndex-1):(headIndex+1);

            currentState = Integer.parseInt(ruleSplit[2]);
        } else{
            StringBuilder newTape = new StringBuilder(tape);
            newTape.setCharAt(headIndex, ruleSplit[3].toCharArray()[0]);
            tape = newTape.toString();

            headIndex = (ruleSplit[4].equals("L"))?(headIndex-1):(headIndex+1);

            currentState = Integer.parseInt(ruleSplit[5]);
        }
        System.out.println(tape);
        if(currentState<rules.length){
            run();
        }
    }
}
