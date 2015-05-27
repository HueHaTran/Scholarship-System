package uit.se06.scholarshipweb.bus.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uit.se06.scholarshipweb.model.ISimpleModel;

public class Utility {

	// ============================================================
	// VARIABLES
	// ============================================================

	private static Utility INS;

	private DateFormat dateFormat;

	private static final Logger logger = LoggerFactory.getLogger(Utility.class);

	// ============================================================
	// STATIC METHODS
	// ============================================================

	public static Utility getIns() {
		if (INS == null) {
			INS = new Utility();
		}
		return INS;
	}

	// ============================================================
	// CONSTRUCTORS
	// ============================================================

	private Utility() {
		dateFormat = new SimpleDateFormat(Contants.CONF_DATE_FORMAT);
	}

	// ============================================================
	// METHODS
	// ============================================================

	public String getDateString(Date date) {
		if (date != null) {
			return dateFormat.format(date);
		} else {
			return Contants.TAG_NO_ANSWER;
		}
	}

	/**
	 * 
	 * @param min
	 * @param max
	 * @return min -> max (no min: <= max; no max: >=min)
	 */
	public String getMoneyString(int min, int max) {
		if (min <= 0) {// no min
			if (max > 0) {
				return "<= " + max + " " + Contants.TAG_MONEY_CURRENCY;
			} else {
				return Contants.TAG_NO_ANSWER;
			}
		} else {
			if (max <= 0) {// no max
				return ">= " + min + " " + Contants.TAG_MONEY_CURRENCY;
			}
		}
		return min + " -> " + max + " " + Contants.TAG_MONEY_CURRENCY;
	}

	public String getMoneyString(int value) {
		if (value > 0) {
			return value + " " + Contants.TAG_MONEY_CURRENCY;
		}
		return Contants.TAG_NO_ANSWER;
	}

	public String getNameString(ISimpleModel model) {
		if (model != null) {
			return model.getName().trim();
		} else {
			return Contants.TAG_NO_ANSWER;
		}
	}

	public String getNamesString(Set<? extends ISimpleModel> models) {
		if (models != null && !models.isEmpty()) {
			StringBuilder builder = new StringBuilder();
			String prefix = "";
			for (ISimpleModel s : models) {
				builder.append(prefix);
				prefix = ", ";// not affect performance!
				builder.append(s.getName().trim());
			}
			return builder.toString();
		}
		return Contants.TAG_NO_ANSWER;
	}

	public String getNamesString(List<? extends ISimpleModel> models) {
		return getNamesString(new HashSet<ISimpleModel>(models));
	}

	public List<String> getNameList(Set<? extends ISimpleModel> models) {
		List<String> result = new ArrayList<String>();
		if (models != null && !models.isEmpty()) {
			for (ISimpleModel s : models) {
				result.add(s.getName().trim());
			}
		}
		return result;
	}

	public List<String> getNameList(List<? extends ISimpleModel> models) {
		return getNameList(new HashSet<ISimpleModel>(models));
	}

	public String getFormatNumberString(int value) {
		NumberFormat anotherFormat = NumberFormat
				.getNumberInstance(Locale.GERMAN);
		try {
			if (anotherFormat instanceof DecimalFormat) {
				DecimalFormat anotherDFormat = (DecimalFormat) anotherFormat;
				anotherDFormat.applyPattern("#.00");
				anotherDFormat.setGroupingUsed(true);
				anotherDFormat.setGroupingSize(3);
			} else {
				logger.error("Error in " + this.getClass().getCanonicalName()
						+ ": Can't format number in "
						+ "getFormatNumberString(" + value + ").");
			}
		} catch (Exception ex) {
			logger.error("Exception in " + this.getClass().getCanonicalName()
					+ "(getFormatNumberString()): " + ex);
		}
		return String.valueOf(value);
	}

	public String getFormatString(String value) {
		if (value == null) {
			return Contants.TAG_NO_ANSWER;
		}
		return value.trim();
	}
}
