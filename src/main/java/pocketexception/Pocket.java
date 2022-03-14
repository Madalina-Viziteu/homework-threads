package pocketexception;

public class Pocket {
        private double money;

        public Pocket() {
            this.money = money;
        }

        public double getMoney() {
            if (money <= 10) {
                return 0;
            }
            return money;
        }

        public void setMoney(double money) throws MoreMoneyException, LessMoneyException {
            if (money < 0) {
                throw new LessMoneyException();
            } else if (money > 3000) {
                throw new MoreMoneyException();
            }
            this.money = money;
        }

        @Override
        public String toString() {
            return "Money in the pocket: " + getMoney();
        }
    }
