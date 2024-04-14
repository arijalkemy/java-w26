public class Nthreeseries extends Prototipo{
        private int value ;

        @Override
        public int nextNumber() {
            setValue(getValue() + 3);
            return getValue();
        }

        @Override
        public void restartSeries() {
            setValue(3);
        }

        @Override
        public void initialValue(int i) {
            setValue(i);
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
