package be.jtw.domotic.hkavrgw.request;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by julien on 31/03/2018.
 */
@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "harman")
@XmlAccessorType(XmlAccessType.FIELD)
public class Harman {

    @XmlElement
    private Avr avr;

    @NoArgsConstructor
    @XmlRootElement(name = "avr")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Avr {
        @XmlElement
        private Common common;

        public Common getCommon() {
            return common;
        }

        public void setCommon(Common common) {
            this.common = common;
        }
    }

    @NoArgsConstructor
    @XmlRootElement(name = "common")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Common {
        @XmlElement
        private Control control;

        public Control getControl() {
            return control;
        }

        public void setControl(Control control) {
            this.control = control;
        }
    }

    @NoArgsConstructor
    @XmlRootElement(name = "control")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Control {
        @XmlElement
        private String name;
        @XmlElement
        private String zone;
        @XmlElement
        private String para;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getZone() {
            return zone;
        }

        public void setZone(String zone) {
            this.zone = zone;
        }

        public String getPara() {
            return para;
        }

        public void setPara(String para) {
            this.para = para;
        }
    }
}
