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
		dateFormat = new SimpleDateFormat(Constants.CONF_DATE_FORMAT);
	}

	// ============================================================
	// METHODS
	// ============================================================

	public String getDateString(Date date, boolean allowEmpty) {
		if (date != null) {
			return dateFormat.format(date);
		} else if (!allowEmpty) {
			return Constants.TAG_NO_ANSWER;
		} else {
			return "";
		}
	}

	/**
	 * 
	 * @param min
	 * @param max
	 * @return min -> max (no min: <= max; no max: >=min)
	 */
	public String getMoneyString(int min, int max, boolean allowEmpty) {
		if (min <= 0) {// no min
			if (max > 0) {
				return "<= " + max + " " + Constants.TAG_MONEY_CURRENCY;
			} else {
				if (!allowEmpty) {
					return Constants.TAG_NO_ANSWER;
				} else {
					return "";
				}
			}
		} else {
			if (max <= 0) {// no max
				return ">= " + min + " " + Constants.TAG_MONEY_CURRENCY;
			}
		}
		return min + " -> " + max + " " + Constants.TAG_MONEY_CURRENCY;
	}

	public String getMoneyString(int value, boolean allowEmpty) {
		if (value > 0) {
			return value + " " + Constants.TAG_MONEY_CURRENCY;
		}
		if (!allowEmpty) {
			return Constants.TAG_NO_ANSWER;
		} else {
			return "";
		}
	}

	public String getNameString(ISimpleModel model, boolean allowEmpty) {
		if (model != null) {
			return model.getName().trim();
		} else if (!allowEmpty) {
			return Constants.TAG_NO_ANSWER;
		} else {
			return "";
		}
	}

	public String getNamesString(Set<? extends ISimpleModel> models,
			boolean allowEmpty) {
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
		if (!allowEmpty) {
			return Constants.TAG_NO_ANSWER;
		} else {
			return "";
		}
	}

	public String getNamesString(List<? extends ISimpleModel> models,
			boolean allowEmpty) {
		return getNamesString(new HashSet<ISimpleModel>(models), allowEmpty);
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

	public String getFormatNumberString(int value, boolean allowEmpty) {
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
		if (value == 0) {
			if (allowEmpty) {
				return "";
			} else {
				return Constants.TAG_NO_ANSWER;
			}
		}
		return String.valueOf(value);
	}

	public String getFormatString(String value, boolean allowEmpty) {
		if (value == null) {
			if (!allowEmpty) {
				return Constants.TAG_NO_ANSWER;
			} else {
				return "";
			}
		}
		return value.trim();
	}
}
