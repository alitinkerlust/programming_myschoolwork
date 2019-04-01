class Type1Adjustment implements SalaryAdjust {

    @Override
    public double adjust(double raise) {
        if (raise < 0) {
            return 0;
        } else if (raise > 10) {
            return 10;
        } else {
            return raise;
        }
    }
}
