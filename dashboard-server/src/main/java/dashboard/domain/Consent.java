package dashboard.domain;

public class Consent {

    private String spEntityId;
    private ConsentType type;
    private String explanationNl;
    private String explanationEn;
    private String explanationPt;

    public Consent() {
    }

    public Consent(String spEntityId, ConsentType type, String explanationNl, String explanationEn, String explanationPt) {
        this.spEntityId = spEntityId;
        this.type = type;
        this.explanationNl = explanationNl;
        this.explanationEn = explanationEn;
        this.explanationPt = explanationPt;
    }

    public String getSpEntityId() {
        return spEntityId;
    }

    public void setSpEntityId(String spEntityId) {
        this.spEntityId = spEntityId;
    }

    public ConsentType getType() {
        return type;
    }

    public void setType(ConsentType type) {
        this.type = type;
    }

    public String getExplanationNl() {
        return explanationNl;
    }

    public void setExplanationNl(String explanationNl) {
        this.explanationNl = explanationNl;
    }

    public String getExplanationEn() {
        return explanationEn;
    }

    public void setExplanationEn(String explanationEn) {
        this.explanationEn = explanationEn;
    }

    public String getExplanationPt() {
        return explanationPt;
    }

    public void setExplanationPt(String explanationPt) {
        this.explanationPt = explanationPt;
    }

    @Override
    public String toString() {
        return "Consent{" +
                "spEntityId='" + spEntityId + '\'' +
                ", type=" + type +
                ", explanationNl='" + explanationNl + '\'' +
                ", explanationEn='" + explanationEn + '\'' +
                ", explanationPt='" + explanationPt + '\'' +
                '}';
    }
}
