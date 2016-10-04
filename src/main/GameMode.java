package main;

public enum GameMode {
    Easy {
        @Override
        public Ladders ladders() {
            Ladders ladders = new Ladders(5);
            try {
                ladders.add(new Ladder(8, 20));
                ladders.add(new Ladder(25, 38));
                ladders.add(new Ladder(44, 64));
                ladders.add(new Ladder(55, 88));
                ladders.add(new Ladder(62, 98));
            }
            catch (InvalidLadderException ex){}
            return ladders;
        }

        @Override
        public Snakes snakes() {
            Snakes snakes = new Snakes(5);
            snakes.add(new Snake(48,14));
            snakes.add(new Snake(30,5));
            snakes.add(new Snake(59,21));
            snakes.add(new Snake(99,62));
            snakes.add(new Snake(83,66));
            return snakes;
        }
    },
    Medium{
        @Override
        public Ladders ladders() {
            Ladders ladders = new Ladders(5);
            try {
                ladders.add(new Ladder(8, 20));
                ladders.add(new Ladder(25, 38));
                ladders.add(new Ladder(44, 64));
                ladders.add(new Ladder(55, 88));
                ladders.add(new Ladder(62, 98));
            }
            catch (InvalidLadderException ex){}
            return ladders;
        }

        @Override
        public Snakes snakes() {
            Snakes snakes = new Snakes(5);
            snakes.add(new Snake(48,14));
            snakes.add(new Snake(30,5));
            snakes.add(new Snake(59,21));
            snakes.add(new Snake(99,62));
            snakes.add(new Snake(83,66));
            return snakes;
        }
    },
    Hard{
        @Override
        public Ladders ladders() {
            Ladders ladders = new Ladders(5);
            try {
                ladders.add(new Ladder(8, 20));
                ladders.add(new Ladder(25, 38));
                ladders.add(new Ladder(44, 64));
                ladders.add(new Ladder(55, 88));
                ladders.add(new Ladder(62, 98));
            }
            catch (InvalidLadderException ex){}
            return ladders;
        }

        @Override
        public Snakes snakes() {
            Snakes snakes = new Snakes(5);
            snakes.add(new Snake(48,14));
            snakes.add(new Snake(30,5));
            snakes.add(new Snake(59,21));
            snakes.add(new Snake(99,62));
            snakes.add(new Snake(83,66));
            return snakes;
        }
    };

    public Ladders ladders() {
        return null;
    }

    public Snakes snakes() {
        return null;
    }
}
