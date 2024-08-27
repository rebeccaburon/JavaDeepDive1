package app.Uge1.Excercises1_StreamsAndDateTimeAPI.e2Collectors;

    class Transaction {
        private int id;
        private double amount;
        private String currency;

        public Transaction(int id, double amount, String currency) {
            this.id = id;
            this.amount = amount;
            this.currency = currency;
        }

        public double getAmount() {
            return amount;
        }

        public String getCurrency() {
            return currency;
        }
    }

