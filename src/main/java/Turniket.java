class Turniket {

    static boolean checkSkipass(Skipass skipass) {
        boolean result;
        result = skipass.isValid() && !skipass.isBlocked() &&
                !skipass.isExpired() && skipass.use();

        SkipassSystem.logSkipassUsage(skipass, result);

        if (!result){
            SkipassSystem.blockSkipass(skipass.getUniqueID());
        }
        return result;
    }
}
