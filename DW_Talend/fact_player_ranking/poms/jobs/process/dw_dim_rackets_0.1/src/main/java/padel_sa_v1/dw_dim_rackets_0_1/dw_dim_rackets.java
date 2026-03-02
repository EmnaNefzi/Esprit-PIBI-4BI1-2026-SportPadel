// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.

package padel_sa_v1.dw_dim_rackets_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: dw_dim_rackets Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class dw_dim_rackets implements TalendJob {

	protected static void logIgnoredError(String message, Throwable cause) {
		System.err.println(message);
		if (cause != null) {
			cause.printStackTrace();
		}

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "dw_dim_rackets";
	private final String projectName = "PADEL_SA_V1";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					dw_dim_rackets.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(dw_dim_rackets.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tDBRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBRow_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tUniqRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBRow_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBInput_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBRow_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBRow_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tDBRow_1 begin ] start
				 */

				ok_Hash.put("tDBRow_1", false);
				start_Hash.put("tDBRow_1", System.currentTimeMillis());

				currentComponent = "tDBRow_1";

				int tos_count_tDBRow_1 = 0;

				java.sql.Connection conn_tDBRow_1 = null;
				String query_tDBRow_1 = "";
				boolean whetherReject_tDBRow_1 = false;
				String driverClass_tDBRow_1 = "org.postgresql.Driver";
				java.lang.Class jdbcclazz_tDBRow_1 = java.lang.Class.forName(driverClass_tDBRow_1);

				String url_tDBRow_1 = "jdbc:postgresql://" + "localhost" + ":" + "5432" + "/" + "padel_DWH";

				String dbUser_tDBRow_1 = "postgres";

				final String decryptedPassword_tDBRow_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:O2Nq/0oSpomBA4DA6K/JNYPdJnA/vX6dKmGKB64GD/HGf2QOjg==");

				String dbPwd_tDBRow_1 = decryptedPassword_tDBRow_1;

				conn_tDBRow_1 = java.sql.DriverManager.getConnection(url_tDBRow_1, dbUser_tDBRow_1, dbPwd_tDBRow_1);

				resourceMap.put("conn_tDBRow_1", conn_tDBRow_1);
				if (conn_tDBRow_1.getAutoCommit()) {

					conn_tDBRow_1.setAutoCommit(false);

				}
				int commitEvery_tDBRow_1 = 10000;
				int commitCounter_tDBRow_1 = 0;

				java.sql.Statement stmt_tDBRow_1 = conn_tDBRow_1.createStatement();
				resourceMap.put("stmt_tDBRow_1", stmt_tDBRow_1);

				/**
				 * [tDBRow_1 begin ] stop
				 */

				/**
				 * [tDBRow_1 main ] start
				 */

				currentComponent = "tDBRow_1";

				query_tDBRow_1 = "TRUNCATE TABLE dw.dim_raquette RESTART IDENTITY";
				whetherReject_tDBRow_1 = false;
				globalMap.put("tDBRow_1_QUERY", query_tDBRow_1);
				try {
					stmt_tDBRow_1.execute(query_tDBRow_1);

				} catch (java.lang.Exception e) {
					whetherReject_tDBRow_1 = true;

					System.err.print(e.getMessage());
					globalMap.put("tDBRow_1_ERROR_MESSAGE", e.getMessage());

				}

				if (!whetherReject_tDBRow_1) {

				}

				commitCounter_tDBRow_1++;
				if (commitEvery_tDBRow_1 <= commitCounter_tDBRow_1) {

					conn_tDBRow_1.commit();

					commitCounter_tDBRow_1 = 0;
				}

				tos_count_tDBRow_1++;

				/**
				 * [tDBRow_1 main ] stop
				 */

				/**
				 * [tDBRow_1 process_data_begin ] start
				 */

				currentComponent = "tDBRow_1";

				/**
				 * [tDBRow_1 process_data_begin ] stop
				 */

				/**
				 * [tDBRow_1 process_data_end ] start
				 */

				currentComponent = "tDBRow_1";

				/**
				 * [tDBRow_1 process_data_end ] stop
				 */

				/**
				 * [tDBRow_1 end ] start
				 */

				currentComponent = "tDBRow_1";

				stmt_tDBRow_1.close();
				resourceMap.remove("stmt_tDBRow_1");
				resourceMap.put("statementClosed_tDBRow_1", true);
				if (commitEvery_tDBRow_1 > commitCounter_tDBRow_1) {

					conn_tDBRow_1.commit();

					commitCounter_tDBRow_1 = 0;

				}
				conn_tDBRow_1.close();

				if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
						&& routines.system.BundleUtils.inOSGi()) {
					Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").getMethod("checkedShutdown")
							.invoke(null, (Object[]) null);
				}

				resourceMap.put("finish_tDBRow_1", true);

				ok_Hash.put("tDBRow_1", true);
				end_Hash.put("tDBRow_1", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tDBInput_1Process(globalMap);

				/**
				 * [tDBRow_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBRow_1 finally ] start
				 */

				currentComponent = "tDBRow_1";

				try {
					if (resourceMap.get("statementClosed_tDBRow_1") == null) {
						java.sql.Statement stmtToClose_tDBRow_1 = null;
						if ((stmtToClose_tDBRow_1 = (java.sql.Statement) resourceMap.remove("stmt_tDBRow_1")) != null) {
							stmtToClose_tDBRow_1.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBRow_1") == null) {
						java.sql.Connection ctn_tDBRow_1 = null;
						if ((ctn_tDBRow_1 = (java.sql.Connection) resourceMap.get("conn_tDBRow_1")) != null) {
							try {
								ctn_tDBRow_1.close();
							} catch (java.sql.SQLException sqlEx_tDBRow_1) {
								String errorMessage_tDBRow_1 = "failed to close the connection in tDBRow_1 :"
										+ sqlEx_tDBRow_1.getMessage();
								System.err.println(errorMessage_tDBRow_1);
							}
						}
					}
				}

				/**
				 * [tDBRow_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBRow_1_SUBPROCESS_STATE", 1);
	}

	public static class out_insertStruct implements routines.system.IPersistableRow<out_insertStruct> {
		final static byte[] commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets = new byte[0];
		static byte[] commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[0];

		public String sku;

		public String getSku() {
			return this.sku;
		}

		public String modele;

		public String getModele() {
			return this.modele;
		}

		public String marque;

		public String getMarque() {
			return this.marque;
		}

		public BigDecimal prix;

		public BigDecimal getPrix() {
			return this.prix;
		}

		public String categorie_prix;

		public String getCategorie_prix() {
			return this.categorie_prix;
		}

		public String annee;

		public String getAnnee() {
			return this.annee;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PADEL_SA_V1_dw_dim_rackets.length) {
					if (length < 1024 && commonByteArray_PADEL_SA_V1_dw_dim_rackets.length == 0) {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[1024];
					} else {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length);
				strReturn = new String(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PADEL_SA_V1_dw_dim_rackets.length) {
					if (length < 1024 && commonByteArray_PADEL_SA_V1_dw_dim_rackets.length == 0) {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[1024];
					} else {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length);
				strReturn = new String(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets) {

				try {

					int length = 0;

					this.sku = readString(dis);

					this.modele = readString(dis);

					this.marque = readString(dis);

					this.prix = (BigDecimal) dis.readObject();

					this.categorie_prix = readString(dis);

					this.annee = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets) {

				try {

					int length = 0;

					this.sku = readString(dis);

					this.modele = readString(dis);

					this.marque = readString(dis);

					this.prix = (BigDecimal) dis.readObject();

					this.categorie_prix = readString(dis);

					this.annee = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.sku, dos);

				// String

				writeString(this.modele, dos);

				// String

				writeString(this.marque, dos);

				// BigDecimal

				dos.writeObject(this.prix);

				// String

				writeString(this.categorie_prix, dos);

				// String

				writeString(this.annee, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.sku, dos);

				// String

				writeString(this.modele, dos);

				// String

				writeString(this.marque, dos);

				// BigDecimal

				dos.writeObject(this.prix);

				// String

				writeString(this.categorie_prix, dos);

				// String

				writeString(this.annee, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("sku=" + sku);
			sb.append(",modele=" + modele);
			sb.append(",marque=" + marque);
			sb.append(",prix=" + String.valueOf(prix));
			sb.append(",categorie_prix=" + categorie_prix);
			sb.append(",annee=" + annee);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(out_insertStruct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class out_updateStruct implements routines.system.IPersistableRow<out_updateStruct> {
		final static byte[] commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets = new byte[0];
		static byte[] commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public Integer id_raquette;

		public Integer getId_raquette() {
			return this.id_raquette;
		}

		public String sku;

		public String getSku() {
			return this.sku;
		}

		public String modele;

		public String getModele() {
			return this.modele;
		}

		public String marque;

		public String getMarque() {
			return this.marque;
		}

		public BigDecimal prix;

		public BigDecimal getPrix() {
			return this.prix;
		}

		public String categorie_prix;

		public String getCategorie_prix() {
			return this.categorie_prix;
		}

		public String annee;

		public String getAnnee() {
			return this.annee;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.id_raquette == null) ? 0 : this.id_raquette.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final out_updateStruct other = (out_updateStruct) obj;

			if (this.id_raquette == null) {
				if (other.id_raquette != null)
					return false;

			} else if (!this.id_raquette.equals(other.id_raquette))

				return false;

			return true;
		}

		public void copyDataTo(out_updateStruct other) {

			other.id_raquette = this.id_raquette;
			other.sku = this.sku;
			other.modele = this.modele;
			other.marque = this.marque;
			other.prix = this.prix;
			other.categorie_prix = this.categorie_prix;
			other.annee = this.annee;

		}

		public void copyKeysDataTo(out_updateStruct other) {

			other.id_raquette = this.id_raquette;

		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PADEL_SA_V1_dw_dim_rackets.length) {
					if (length < 1024 && commonByteArray_PADEL_SA_V1_dw_dim_rackets.length == 0) {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[1024];
					} else {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length);
				strReturn = new String(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PADEL_SA_V1_dw_dim_rackets.length) {
					if (length < 1024 && commonByteArray_PADEL_SA_V1_dw_dim_rackets.length == 0) {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[1024];
					} else {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length);
				strReturn = new String(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets) {

				try {

					int length = 0;

					this.id_raquette = readInteger(dis);

					this.sku = readString(dis);

					this.modele = readString(dis);

					this.marque = readString(dis);

					this.prix = (BigDecimal) dis.readObject();

					this.categorie_prix = readString(dis);

					this.annee = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets) {

				try {

					int length = 0;

					this.id_raquette = readInteger(dis);

					this.sku = readString(dis);

					this.modele = readString(dis);

					this.marque = readString(dis);

					this.prix = (BigDecimal) dis.readObject();

					this.categorie_prix = readString(dis);

					this.annee = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.id_raquette, dos);

				// String

				writeString(this.sku, dos);

				// String

				writeString(this.modele, dos);

				// String

				writeString(this.marque, dos);

				// BigDecimal

				dos.writeObject(this.prix);

				// String

				writeString(this.categorie_prix, dos);

				// String

				writeString(this.annee, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.id_raquette, dos);

				// String

				writeString(this.sku, dos);

				// String

				writeString(this.modele, dos);

				// String

				writeString(this.marque, dos);

				// BigDecimal

				dos.writeObject(this.prix);

				// String

				writeString(this.categorie_prix, dos);

				// String

				writeString(this.annee, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id_raquette=" + String.valueOf(id_raquette));
			sb.append(",sku=" + sku);
			sb.append(",modele=" + modele);
			sb.append(",marque=" + marque);
			sb.append(",prix=" + String.valueOf(prix));
			sb.append(",categorie_prix=" + categorie_prix);
			sb.append(",annee=" + annee);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(out_updateStruct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.id_raquette, other.id_raquette);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets = new byte[0];
		static byte[] commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[0];

		public String sku;

		public String getSku() {
			return this.sku;
		}

		public String modele;

		public String getModele() {
			return this.modele;
		}

		public String marque;

		public String getMarque() {
			return this.marque;
		}

		public BigDecimal prix;

		public BigDecimal getPrix() {
			return this.prix;
		}

		public String categorie_prix;

		public String getCategorie_prix() {
			return this.categorie_prix;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PADEL_SA_V1_dw_dim_rackets.length) {
					if (length < 1024 && commonByteArray_PADEL_SA_V1_dw_dim_rackets.length == 0) {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[1024];
					} else {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length);
				strReturn = new String(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PADEL_SA_V1_dw_dim_rackets.length) {
					if (length < 1024 && commonByteArray_PADEL_SA_V1_dw_dim_rackets.length == 0) {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[1024];
					} else {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length);
				strReturn = new String(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets) {

				try {

					int length = 0;

					this.sku = readString(dis);

					this.modele = readString(dis);

					this.marque = readString(dis);

					this.prix = (BigDecimal) dis.readObject();

					this.categorie_prix = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets) {

				try {

					int length = 0;

					this.sku = readString(dis);

					this.modele = readString(dis);

					this.marque = readString(dis);

					this.prix = (BigDecimal) dis.readObject();

					this.categorie_prix = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.sku, dos);

				// String

				writeString(this.modele, dos);

				// String

				writeString(this.marque, dos);

				// BigDecimal

				dos.writeObject(this.prix);

				// String

				writeString(this.categorie_prix, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.sku, dos);

				// String

				writeString(this.modele, dos);

				// String

				writeString(this.marque, dos);

				// BigDecimal

				dos.writeObject(this.prix);

				// String

				writeString(this.categorie_prix, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("sku=" + sku);
			sb.append(",modele=" + modele);
			sb.append(",marque=" + marque);
			sb.append(",prix=" + String.valueOf(prix));
			sb.append(",categorie_prix=" + categorie_prix);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
		final static byte[] commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets = new byte[0];
		static byte[] commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[0];

		public String sku;

		public String getSku() {
			return this.sku;
		}

		public String modele;

		public String getModele() {
			return this.modele;
		}

		public String marque;

		public String getMarque() {
			return this.marque;
		}

		public BigDecimal prix;

		public BigDecimal getPrix() {
			return this.prix;
		}

		public String categorie_prix;

		public String getCategorie_prix() {
			return this.categorie_prix;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PADEL_SA_V1_dw_dim_rackets.length) {
					if (length < 1024 && commonByteArray_PADEL_SA_V1_dw_dim_rackets.length == 0) {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[1024];
					} else {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length);
				strReturn = new String(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PADEL_SA_V1_dw_dim_rackets.length) {
					if (length < 1024 && commonByteArray_PADEL_SA_V1_dw_dim_rackets.length == 0) {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[1024];
					} else {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length);
				strReturn = new String(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets) {

				try {

					int length = 0;

					this.sku = readString(dis);

					this.modele = readString(dis);

					this.marque = readString(dis);

					this.prix = (BigDecimal) dis.readObject();

					this.categorie_prix = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets) {

				try {

					int length = 0;

					this.sku = readString(dis);

					this.modele = readString(dis);

					this.marque = readString(dis);

					this.prix = (BigDecimal) dis.readObject();

					this.categorie_prix = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.sku, dos);

				// String

				writeString(this.modele, dos);

				// String

				writeString(this.marque, dos);

				// BigDecimal

				dos.writeObject(this.prix);

				// String

				writeString(this.categorie_prix, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.sku, dos);

				// String

				writeString(this.modele, dos);

				// String

				writeString(this.marque, dos);

				// BigDecimal

				dos.writeObject(this.prix);

				// String

				writeString(this.categorie_prix, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("sku=" + sku);
			sb.append(",modele=" + modele);
			sb.append(",marque=" + marque);
			sb.append(",prix=" + String.valueOf(prix));
			sb.append(",categorie_prix=" + categorie_prix);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(out1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets = new byte[0];
		static byte[] commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[0];

		public String sku;

		public String getSku() {
			return this.sku;
		}

		public String modele;

		public String getModele() {
			return this.modele;
		}

		public String marque;

		public String getMarque() {
			return this.marque;
		}

		public BigDecimal prix;

		public BigDecimal getPrix() {
			return this.prix;
		}

		public String categorie_prix;

		public String getCategorie_prix() {
			return this.categorie_prix;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PADEL_SA_V1_dw_dim_rackets.length) {
					if (length < 1024 && commonByteArray_PADEL_SA_V1_dw_dim_rackets.length == 0) {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[1024];
					} else {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length);
				strReturn = new String(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PADEL_SA_V1_dw_dim_rackets.length) {
					if (length < 1024 && commonByteArray_PADEL_SA_V1_dw_dim_rackets.length == 0) {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[1024];
					} else {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length);
				strReturn = new String(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets) {

				try {

					int length = 0;

					this.sku = readString(dis);

					this.modele = readString(dis);

					this.marque = readString(dis);

					this.prix = (BigDecimal) dis.readObject();

					this.categorie_prix = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets) {

				try {

					int length = 0;

					this.sku = readString(dis);

					this.modele = readString(dis);

					this.marque = readString(dis);

					this.prix = (BigDecimal) dis.readObject();

					this.categorie_prix = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.sku, dos);

				// String

				writeString(this.modele, dos);

				// String

				writeString(this.marque, dos);

				// BigDecimal

				dos.writeObject(this.prix);

				// String

				writeString(this.categorie_prix, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.sku, dos);

				// String

				writeString(this.modele, dos);

				// String

				writeString(this.marque, dos);

				// BigDecimal

				dos.writeObject(this.prix);

				// String

				writeString(this.categorie_prix, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("sku=" + sku);
			sb.append(",modele=" + modele);
			sb.append(",marque=" + marque);
			sb.append(",prix=" + String.valueOf(prix));
			sb.append(",categorie_prix=" + categorie_prix);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class after_tDBInput_1Struct implements routines.system.IPersistableRow<after_tDBInput_1Struct> {
		final static byte[] commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets = new byte[0];
		static byte[] commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[0];

		public String sku;

		public String getSku() {
			return this.sku;
		}

		public String modele;

		public String getModele() {
			return this.modele;
		}

		public String marque;

		public String getMarque() {
			return this.marque;
		}

		public BigDecimal prix;

		public BigDecimal getPrix() {
			return this.prix;
		}

		public String categorie_prix;

		public String getCategorie_prix() {
			return this.categorie_prix;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PADEL_SA_V1_dw_dim_rackets.length) {
					if (length < 1024 && commonByteArray_PADEL_SA_V1_dw_dim_rackets.length == 0) {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[1024];
					} else {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length);
				strReturn = new String(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PADEL_SA_V1_dw_dim_rackets.length) {
					if (length < 1024 && commonByteArray_PADEL_SA_V1_dw_dim_rackets.length == 0) {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[1024];
					} else {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length);
				strReturn = new String(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets) {

				try {

					int length = 0;

					this.sku = readString(dis);

					this.modele = readString(dis);

					this.marque = readString(dis);

					this.prix = (BigDecimal) dis.readObject();

					this.categorie_prix = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets) {

				try {

					int length = 0;

					this.sku = readString(dis);

					this.modele = readString(dis);

					this.marque = readString(dis);

					this.prix = (BigDecimal) dis.readObject();

					this.categorie_prix = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.sku, dos);

				// String

				writeString(this.modele, dos);

				// String

				writeString(this.marque, dos);

				// BigDecimal

				dos.writeObject(this.prix);

				// String

				writeString(this.categorie_prix, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.sku, dos);

				// String

				writeString(this.modele, dos);

				// String

				writeString(this.marque, dos);

				// BigDecimal

				dos.writeObject(this.prix);

				// String

				writeString(this.categorie_prix, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("sku=" + sku);
			sb.append(",modele=" + modele);
			sb.append(",marque=" + marque);
			sb.append(",prix=" + String.valueOf(prix));
			sb.append(",categorie_prix=" + categorie_prix);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tDBInput_1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				tDBInput_2Process(globalMap);

				row1Struct row1 = new row1Struct();
				out1Struct out1 = new out1Struct();
				row2Struct row2 = new row2Struct();
				out_insertStruct out_insert = new out_insertStruct();
				out_updateStruct out_update = new out_updateStruct();

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "out_insert");
				}

				int tos_count_tDBOutput_1 = 0;

				String dbschema_tDBOutput_1 = null;
				dbschema_tDBOutput_1 = "dw";

				String tableName_tDBOutput_1 = null;
				if (dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
					tableName_tDBOutput_1 = ("dim_raquette");
				} else {
					tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "\".\"" + ("dim_raquette");
				}

				int nb_line_tDBOutput_1 = 0;
				int nb_line_update_tDBOutput_1 = 0;
				int nb_line_inserted_tDBOutput_1 = 0;
				int nb_line_deleted_tDBOutput_1 = 0;
				int nb_line_rejected_tDBOutput_1 = 0;

				int deletedCount_tDBOutput_1 = 0;
				int updatedCount_tDBOutput_1 = 0;
				int insertedCount_tDBOutput_1 = 0;
				int rowsToCommitCount_tDBOutput_1 = 0;
				int rejectedCount_tDBOutput_1 = 0;

				boolean whetherReject_tDBOutput_1 = false;

				java.sql.Connection conn_tDBOutput_1 = null;
				String dbUser_tDBOutput_1 = null;

				java.lang.Class.forName("org.postgresql.Driver");

				String url_tDBOutput_1 = "jdbc:postgresql://" + "localhost" + ":" + "5432" + "/" + "padel_DWH";
				dbUser_tDBOutput_1 = "postgres";

				final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:gxYtpyUiMYKgcgEPHwLxEDEluZjZ7O12t4tEFDGtDYi3XSvm7Q==");

				String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;

				conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1,
						dbPwd_tDBOutput_1);

				resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
				conn_tDBOutput_1.setAutoCommit(false);
				int commitEvery_tDBOutput_1 = 10000;
				int commitCounter_tDBOutput_1 = 0;

				int batchSize_tDBOutput_1 = 10000;
				int batchSizeCounter_tDBOutput_1 = 0;

				int count_tDBOutput_1 = 0;
				String insert_tDBOutput_1 = "INSERT INTO \"" + tableName_tDBOutput_1
						+ "\" (\"sku\",\"modele\",\"marque\",\"prix\",\"categorie_prix\",\"annee\") VALUES (?,?,?,?,?,?)";

				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tDBOutput_2 begin ] start
				 */

				ok_Hash.put("tDBOutput_2", false);
				start_Hash.put("tDBOutput_2", System.currentTimeMillis());

				currentComponent = "tDBOutput_2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "out_update");
				}

				int tos_count_tDBOutput_2 = 0;

				String dbschema_tDBOutput_2 = null;
				dbschema_tDBOutput_2 = "dw";

				String tableName_tDBOutput_2 = null;
				if (dbschema_tDBOutput_2 == null || dbschema_tDBOutput_2.trim().length() == 0) {
					tableName_tDBOutput_2 = ("dim_raquette");
				} else {
					tableName_tDBOutput_2 = dbschema_tDBOutput_2 + "\".\"" + ("dim_raquette");
				}

				int updateKeyCount_tDBOutput_2 = 1;
				if (updateKeyCount_tDBOutput_2 < 1) {
					throw new RuntimeException("For update, Schema must have a key");
				} else if (updateKeyCount_tDBOutput_2 == 7 && true) {
					throw new RuntimeException("For update, every Schema column can not be a key");
				}

				int nb_line_tDBOutput_2 = 0;
				int nb_line_update_tDBOutput_2 = 0;
				int nb_line_inserted_tDBOutput_2 = 0;
				int nb_line_deleted_tDBOutput_2 = 0;
				int nb_line_rejected_tDBOutput_2 = 0;

				int deletedCount_tDBOutput_2 = 0;
				int updatedCount_tDBOutput_2 = 0;
				int insertedCount_tDBOutput_2 = 0;
				int rowsToCommitCount_tDBOutput_2 = 0;
				int rejectedCount_tDBOutput_2 = 0;

				boolean whetherReject_tDBOutput_2 = false;

				java.sql.Connection conn_tDBOutput_2 = null;
				String dbUser_tDBOutput_2 = null;

				java.lang.Class.forName("org.postgresql.Driver");

				String url_tDBOutput_2 = "jdbc:postgresql://" + "localhost" + ":" + "5432" + "/" + "padel_DWH";
				dbUser_tDBOutput_2 = "postgres";

				final String decryptedPassword_tDBOutput_2 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:FIw2BG9mQNbsAmWWdIz63MZMDXs+xauK5+6oC/+fBNGAAuYhag==");

				String dbPwd_tDBOutput_2 = decryptedPassword_tDBOutput_2;

				conn_tDBOutput_2 = java.sql.DriverManager.getConnection(url_tDBOutput_2, dbUser_tDBOutput_2,
						dbPwd_tDBOutput_2);

				resourceMap.put("conn_tDBOutput_2", conn_tDBOutput_2);
				conn_tDBOutput_2.setAutoCommit(false);
				int commitEvery_tDBOutput_2 = 10000;
				int commitCounter_tDBOutput_2 = 0;

				int batchSize_tDBOutput_2 = 10000;
				int batchSizeCounter_tDBOutput_2 = 0;

				int count_tDBOutput_2 = 0;
				String update_tDBOutput_2 = "UPDATE \"" + tableName_tDBOutput_2
						+ "\" SET \"sku\" = ?,\"modele\" = ?,\"marque\" = ?,\"prix\" = ?,\"categorie_prix\" = ?,\"annee\" = ? WHERE \"id_raquette\" = ?";
				java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(update_tDBOutput_2);
				resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);

				/**
				 * [tDBOutput_2 begin ] stop
				 */

				/**
				 * [tMap_2 begin ] start
				 */

				ok_Hash.put("tMap_2", false);
				start_Hash.put("tMap_2", System.currentTimeMillis());

				currentComponent = "tMap_2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row2");
				}

				int tos_count_tMap_2 = 0;

// ###############################
// # Lookup's keys initialization

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) globalMap
						.get("tHash_Lookup_row3"));

				row3Struct row3HashKey = new row3Struct();
				row3Struct row3Default = new row3Struct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_2__Struct {
				}
				Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
				out_insertStruct out_insert_tmp = new out_insertStruct();
				out_updateStruct out_update_tmp = new out_updateStruct();
// ###############################

				/**
				 * [tMap_2 begin ] stop
				 */

				/**
				 * [tUniqRow_1 begin ] start
				 */

				ok_Hash.put("tUniqRow_1", false);
				start_Hash.put("tUniqRow_1", System.currentTimeMillis());

				currentComponent = "tUniqRow_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "out1");
				}

				int tos_count_tUniqRow_1 = 0;

				class KeyStruct_tUniqRow_1 {

					private static final int DEFAULT_HASHCODE = 1;
					private static final int PRIME = 31;
					private int hashCode = DEFAULT_HASHCODE;
					public boolean hashCodeDirty = true;

					String sku;

					@Override
					public int hashCode() {
						if (this.hashCodeDirty) {
							final int prime = PRIME;
							int result = DEFAULT_HASHCODE;

							result = prime * result + ((this.sku == null) ? 0 : this.sku.hashCode());

							this.hashCode = result;
							this.hashCodeDirty = false;
						}
						return this.hashCode;
					}

					@Override
					public boolean equals(Object obj) {
						if (this == obj)
							return true;
						if (obj == null)
							return false;
						if (getClass() != obj.getClass())
							return false;
						final KeyStruct_tUniqRow_1 other = (KeyStruct_tUniqRow_1) obj;

						if (this.sku == null) {
							if (other.sku != null)
								return false;

						} else if (!this.sku.equals(other.sku))

							return false;

						return true;
					}

				}

				int nb_uniques_tUniqRow_1 = 0;
				int nb_duplicates_tUniqRow_1 = 0;
				KeyStruct_tUniqRow_1 finder_tUniqRow_1 = new KeyStruct_tUniqRow_1();
				java.util.Set<KeyStruct_tUniqRow_1> keystUniqRow_1 = new java.util.HashSet<KeyStruct_tUniqRow_1>();

				/**
				 * [tUniqRow_1 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row1");
				}

				int tos_count_tMap_1 = 0;

// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				out1Struct out1_tmp = new out1Struct();
// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tDBInput_1 begin ] start
				 */

				ok_Hash.put("tDBInput_1", false);
				start_Hash.put("tDBInput_1", System.currentTimeMillis());

				currentComponent = "tDBInput_1";

				int tos_count_tDBInput_1 = 0;

				int nb_line_tDBInput_1 = 0;
				java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "org.postgresql.Driver";
				java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = "postgres";

				final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:yJBFNvMKsusCNbEFGS9MWVe0a8ebi3LewAVcM4uqZszeYBjW2A==");

				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;

				String url_tDBInput_1 = "jdbc:postgresql://" + "localhost" + ":" + "5432" + "/" + "padel_bi_SA";

				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1, dbUser_tDBInput_1,
						dbPwd_tDBInput_1);

				conn_tDBInput_1.setAutoCommit(false);

				java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

				String dbquery_tDBInput_1 = "SELECT\n  sku,\n  title AS modele,\n  vendor AS marque,\n  price AS prix,\n  CASE\n    WHEN CAST(price AS numeric) < 10"
						+ "0 THEN '< 100 TND'\n    WHEN CAST(price AS numeric) >= 100 AND CAST(price AS numeric) < 200 THEN '100-200 TND'\nWHEN CAS"
						+ "T(price AS numeric) >= 200 THEN '>200 TND'\n    ELSE 'Non renseigne'\n  END AS categorie_prix\nFROM sa.sa_padel_rackets"
						+ "\nWHERE product_type = 'Raquettes'";

				globalMap.put("tDBInput_1_QUERY", dbquery_tDBInput_1);
				java.sql.ResultSet rs_tDBInput_1 = null;

				try {
					rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
					java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
					int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

					String tmpContent_tDBInput_1 = null;

					while (rs_tDBInput_1.next()) {
						nb_line_tDBInput_1++;

						if (colQtyInRs_tDBInput_1 < 1) {
							row1.sku = null;
						} else {

							row1.sku = routines.system.JDBCUtil.getString(rs_tDBInput_1, 1, false);
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							row1.modele = null;
						} else {

							row1.modele = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							row1.marque = null;
						} else {

							row1.marque = routines.system.JDBCUtil.getString(rs_tDBInput_1, 3, false);
						}
						if (colQtyInRs_tDBInput_1 < 4) {
							row1.prix = null;
						} else {

							row1.prix = rs_tDBInput_1.getBigDecimal(4);
							if (rs_tDBInput_1.wasNull()) {
								row1.prix = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 5) {
							row1.categorie_prix = null;
						} else {

							row1.categorie_prix = routines.system.JDBCUtil.getString(rs_tDBInput_1, 5, false);
						}

						/**
						 * [tDBInput_1 begin ] stop
						 */

						/**
						 * [tDBInput_1 main ] start
						 */

						currentComponent = "tDBInput_1";

						tos_count_tDBInput_1++;

						/**
						 * [tDBInput_1 main ] stop
						 */

						/**
						 * [tDBInput_1 process_data_begin ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_begin ] stop
						 */

						/**
						 * [tMap_1 main ] start
						 */

						currentComponent = "tMap_1";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row1"

							);
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

						// ###############################
						// # Input tables (lookups)
						boolean rejectedInnerJoin_tMap_1 = false;
						boolean mainRowRejected_tMap_1 = false;

						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
							// ###############################
							// # Output tables

							out1 = null;

// # Output table : 'out1'
							out1_tmp.sku = row1.sku;
							out1_tmp.modele = row1.modele;
							out1_tmp.marque = row1.marque;
							out1_tmp.prix = row1.prix;
							out1_tmp.categorie_prix = row1.prix.compareTo(new java.math.BigDecimal("100")) < 0
									? "Entree"
									: row1.prix.compareTo(new java.math.BigDecimal("200")) < 0 ? "Milieu" : "Haut";
							out1 = out1_tmp;
// ###############################

						} // end of Var scope

						rejectedInnerJoin_tMap_1 = false;

						tos_count_tMap_1++;

						/**
						 * [tMap_1 main ] stop
						 */

						/**
						 * [tMap_1 process_data_begin ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_begin ] stop
						 */
// Start of branch "out1"
						if (out1 != null) {

							/**
							 * [tUniqRow_1 main ] start
							 */

							currentComponent = "tUniqRow_1";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "out1"

								);
							}

							row2 = null;
							if (out1.sku == null) {
								finder_tUniqRow_1.sku = null;
							} else {
								finder_tUniqRow_1.sku = out1.sku.toLowerCase();
							}
							finder_tUniqRow_1.hashCodeDirty = true;
							if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
								KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

								if (out1.sku == null) {
									new_tUniqRow_1.sku = null;
								} else {
									new_tUniqRow_1.sku = out1.sku.toLowerCase();
								}

								keystUniqRow_1.add(new_tUniqRow_1);
								if (row2 == null) {

									row2 = new row2Struct();
								}
								row2.sku = out1.sku;
								row2.modele = out1.modele;
								row2.marque = out1.marque;
								row2.prix = out1.prix;
								row2.categorie_prix = out1.categorie_prix;
								nb_uniques_tUniqRow_1++;
							} else {
								nb_duplicates_tUniqRow_1++;
							}

							tos_count_tUniqRow_1++;

							/**
							 * [tUniqRow_1 main ] stop
							 */

							/**
							 * [tUniqRow_1 process_data_begin ] start
							 */

							currentComponent = "tUniqRow_1";

							/**
							 * [tUniqRow_1 process_data_begin ] stop
							 */
// Start of branch "row2"
							if (row2 != null) {

								/**
								 * [tMap_2 main ] start
								 */

								currentComponent = "tMap_2";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "row2"

									);
								}

								boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;

								// ###############################
								// # Input tables (lookups)
								boolean rejectedInnerJoin_tMap_2 = false;
								boolean mainRowRejected_tMap_2 = false;

								///////////////////////////////////////////////
								// Starting Lookup Table "row3"
								///////////////////////////////////////////////

								boolean forceLooprow3 = false;

								row3Struct row3ObjectFromLookup = null;

								if (!rejectedInnerJoin_tMap_2) { // G_TM_M_020

									hasCasePrimitiveKeyWithNull_tMap_2 = false;

									row3HashKey.sku = row2.sku;

									row3HashKey.hashCodeDirty = true;

									tHash_Lookup_row3.lookup(row3HashKey);

								} // G_TM_M_020

								if (tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071

									// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3'
									// and it contains more one result from keys : row3.sku = '" + row3HashKey.sku +
									// "'");
								} // G 071

								row3Struct row3 = null;

								row3Struct fromLookup_row3 = null;
								row3 = row3Default;

								if (tHash_Lookup_row3 != null && tHash_Lookup_row3.hasNext()) { // G 099

									fromLookup_row3 = tHash_Lookup_row3.next();

								} // G 099

								if (fromLookup_row3 != null) {
									row3 = fromLookup_row3;
								}

								// ###############################
								{ // start of Var scope

									// ###############################
									// # Vars tables

									Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
									// ###############################
									// # Output tables

									out_insert = null;
									out_update = null;

// # Output table : 'out_insert'
// # Filter conditions 
									if (

									row3.id_raquette == null

									) {
										out_insert_tmp.sku = row2.sku;
										out_insert_tmp.modele = row2.modele.replaceAll("(?i)" + row2.marque, "")
												.replaceAll("(?i)Raquette de padel ", "")
												.replaceAll("(?i)raquette de test", "")
												.replaceAll("\\s*202[0-9]\\s*", "").trim();
										out_insert_tmp.marque = row2.marque;
										out_insert_tmp.prix = row2.prix;
										out_insert_tmp.categorie_prix = row2.categorie_prix;
										out_insert_tmp.annee = row2.modele != null && row2.modele.matches(".*\\d{4}.*")
												? row2.modele.replaceAll(".*?(\\d{4}).*", "$1")
												: "Unknown";
										out_insert = out_insert_tmp;
									} // closing filter/reject

// # Output table : 'out_update'
// # Filter conditions 
									if (

									row3.id_raquette != null

									) {
										out_update_tmp.id_raquette = row3.id_raquette;
										out_update_tmp.sku = row2.sku;
										out_update_tmp.modele = row2.modele.replaceAll("(?i)" + row2.marque, "")
												.replaceAll("(?i)Raquette de padel ", "")
												.replaceAll("(?i)raquette de test", "")
												.replaceAll("\\s*202[0-9]\\s*", "").trim();
										out_update_tmp.marque = row2.marque;
										out_update_tmp.prix = row2.prix;
										out_update_tmp.categorie_prix = row2.categorie_prix;
										out_update_tmp.annee = row2.modele != null && row2.modele.matches(".*\\d{4}.*")
												? row2.modele.replaceAll(".*?(\\d{4}).*", "$1")
												: "Unknown";
										out_update = out_update_tmp;
									} // closing filter/reject
// ###############################

								} // end of Var scope

								rejectedInnerJoin_tMap_2 = false;

								tos_count_tMap_2++;

								/**
								 * [tMap_2 main ] stop
								 */

								/**
								 * [tMap_2 process_data_begin ] start
								 */

								currentComponent = "tMap_2";

								/**
								 * [tMap_2 process_data_begin ] stop
								 */
// Start of branch "out_insert"
								if (out_insert != null) {

									/**
									 * [tDBOutput_1 main ] start
									 */

									currentComponent = "tDBOutput_1";

									if (execStat) {
										runStat.updateStatOnConnection(iterateId, 1, 1

												, "out_insert"

										);
									}

									whetherReject_tDBOutput_1 = false;
									if (out_insert.sku == null) {
										pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_1.setString(1, out_insert.sku);
									}

									if (out_insert.modele == null) {
										pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_1.setString(2, out_insert.modele);
									}

									if (out_insert.marque == null) {
										pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_1.setString(3, out_insert.marque);
									}

									pstmt_tDBOutput_1.setBigDecimal(4, out_insert.prix);

									if (out_insert.categorie_prix == null) {
										pstmt_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_1.setString(5, out_insert.categorie_prix);
									}

									if (out_insert.annee == null) {
										pstmt_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_1.setString(6, out_insert.annee);
									}

									pstmt_tDBOutput_1.addBatch();
									nb_line_tDBOutput_1++;

									batchSizeCounter_tDBOutput_1++;

									if ((batchSize_tDBOutput_1 > 0)
											&& (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1)) {
										try {
											int countSum_tDBOutput_1 = 0;

											for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
												countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
														: countEach_tDBOutput_1);
											}
											rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

											insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

											batchSizeCounter_tDBOutput_1 = 0;
										} catch (java.sql.BatchUpdateException e_tDBOutput_1) {
											globalMap.put("tDBOutput_1_ERROR_MESSAGE", e_tDBOutput_1.getMessage());
											java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(),
													sqle_tDBOutput_1 = null;
											String errormessage_tDBOutput_1;
											if (ne_tDBOutput_1 != null) {
												// build new exception to provide the original cause
												sqle_tDBOutput_1 = new java.sql.SQLException(
														e_tDBOutput_1.getMessage() + "\ncaused by: "
																+ ne_tDBOutput_1.getMessage(),
														ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(),
														ne_tDBOutput_1);
												errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
											} else {
												errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
											}

											int countSum_tDBOutput_1 = 0;
											for (int countEach_tDBOutput_1 : e_tDBOutput_1.getUpdateCounts()) {
												countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
														: countEach_tDBOutput_1);
											}
											rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

											insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

											System.err.println(errormessage_tDBOutput_1);

										}
									}

									commitCounter_tDBOutput_1++;
									if (commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {
										if ((batchSize_tDBOutput_1 > 0) && (batchSizeCounter_tDBOutput_1 > 0)) {
											try {
												int countSum_tDBOutput_1 = 0;

												for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
													countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
															: countEach_tDBOutput_1);
												}
												rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

												insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

												batchSizeCounter_tDBOutput_1 = 0;
											} catch (java.sql.BatchUpdateException e_tDBOutput_1) {
												globalMap.put("tDBOutput_1_ERROR_MESSAGE", e_tDBOutput_1.getMessage());
												java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(),
														sqle_tDBOutput_1 = null;
												String errormessage_tDBOutput_1;
												if (ne_tDBOutput_1 != null) {
													// build new exception to provide the original cause
													sqle_tDBOutput_1 = new java.sql.SQLException(
															e_tDBOutput_1.getMessage() + "\ncaused by: "
																	+ ne_tDBOutput_1.getMessage(),
															ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(),
															ne_tDBOutput_1);
													errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
												} else {
													errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
												}

												int countSum_tDBOutput_1 = 0;
												for (int countEach_tDBOutput_1 : e_tDBOutput_1.getUpdateCounts()) {
													countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
															: countEach_tDBOutput_1);
												}
												rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

												insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

												System.err.println(errormessage_tDBOutput_1);

											}
										}
										if (rowsToCommitCount_tDBOutput_1 != 0) {

										}
										conn_tDBOutput_1.commit();
										if (rowsToCommitCount_tDBOutput_1 != 0) {

											rowsToCommitCount_tDBOutput_1 = 0;
										}
										commitCounter_tDBOutput_1 = 0;
									}

									tos_count_tDBOutput_1++;

									/**
									 * [tDBOutput_1 main ] stop
									 */

									/**
									 * [tDBOutput_1 process_data_begin ] start
									 */

									currentComponent = "tDBOutput_1";

									/**
									 * [tDBOutput_1 process_data_begin ] stop
									 */

									/**
									 * [tDBOutput_1 process_data_end ] start
									 */

									currentComponent = "tDBOutput_1";

									/**
									 * [tDBOutput_1 process_data_end ] stop
									 */

								} // End of branch "out_insert"

// Start of branch "out_update"
								if (out_update != null) {

									/**
									 * [tDBOutput_2 main ] start
									 */

									currentComponent = "tDBOutput_2";

									if (execStat) {
										runStat.updateStatOnConnection(iterateId, 1, 1

												, "out_update"

										);
									}

									whetherReject_tDBOutput_2 = false;
									if (out_update.sku == null) {
										pstmt_tDBOutput_2.setNull(1, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_2.setString(1, out_update.sku);
									}

									if (out_update.modele == null) {
										pstmt_tDBOutput_2.setNull(2, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_2.setString(2, out_update.modele);
									}

									if (out_update.marque == null) {
										pstmt_tDBOutput_2.setNull(3, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_2.setString(3, out_update.marque);
									}

									pstmt_tDBOutput_2.setBigDecimal(4, out_update.prix);

									if (out_update.categorie_prix == null) {
										pstmt_tDBOutput_2.setNull(5, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_2.setString(5, out_update.categorie_prix);
									}

									if (out_update.annee == null) {
										pstmt_tDBOutput_2.setNull(6, java.sql.Types.VARCHAR);
									} else {
										pstmt_tDBOutput_2.setString(6, out_update.annee);
									}

									if (out_update.id_raquette == null) {
										pstmt_tDBOutput_2.setNull(7 + count_tDBOutput_2, java.sql.Types.INTEGER);
									} else {
										pstmt_tDBOutput_2.setInt(7 + count_tDBOutput_2, out_update.id_raquette);
									}

									pstmt_tDBOutput_2.addBatch();
									nb_line_tDBOutput_2++;

									batchSizeCounter_tDBOutput_2++;

									if ((batchSize_tDBOutput_2 > 0)
											&& (batchSize_tDBOutput_2 <= batchSizeCounter_tDBOutput_2)) {
										try {
											int countSum_tDBOutput_2 = 0;

											for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2.executeBatch()) {
												countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0
														: countEach_tDBOutput_2);
											}
											rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;

											updatedCount_tDBOutput_2 += countSum_tDBOutput_2;

											batchSizeCounter_tDBOutput_2 = 0;
										} catch (java.sql.BatchUpdateException e_tDBOutput_2) {
											globalMap.put("tDBOutput_2_ERROR_MESSAGE", e_tDBOutput_2.getMessage());
											java.sql.SQLException ne_tDBOutput_2 = e_tDBOutput_2.getNextException(),
													sqle_tDBOutput_2 = null;
											String errormessage_tDBOutput_2;
											if (ne_tDBOutput_2 != null) {
												// build new exception to provide the original cause
												sqle_tDBOutput_2 = new java.sql.SQLException(
														e_tDBOutput_2.getMessage() + "\ncaused by: "
																+ ne_tDBOutput_2.getMessage(),
														ne_tDBOutput_2.getSQLState(), ne_tDBOutput_2.getErrorCode(),
														ne_tDBOutput_2);
												errormessage_tDBOutput_2 = sqle_tDBOutput_2.getMessage();
											} else {
												errormessage_tDBOutput_2 = e_tDBOutput_2.getMessage();
											}

											int countSum_tDBOutput_2 = 0;
											for (int countEach_tDBOutput_2 : e_tDBOutput_2.getUpdateCounts()) {
												countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0
														: countEach_tDBOutput_2);
											}
											rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;

											updatedCount_tDBOutput_2 += countSum_tDBOutput_2;

											System.err.println(errormessage_tDBOutput_2);

										}
									}

									commitCounter_tDBOutput_2++;
									if (commitEvery_tDBOutput_2 <= commitCounter_tDBOutput_2) {
										if ((batchSize_tDBOutput_2 > 0) && (batchSizeCounter_tDBOutput_2 > 0)) {
											try {
												int countSum_tDBOutput_2 = 0;

												for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2.executeBatch()) {
													countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0
															: countEach_tDBOutput_2);
												}
												rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;

												updatedCount_tDBOutput_2 += countSum_tDBOutput_2;

												batchSizeCounter_tDBOutput_2 = 0;
											} catch (java.sql.BatchUpdateException e_tDBOutput_2) {
												globalMap.put("tDBOutput_2_ERROR_MESSAGE", e_tDBOutput_2.getMessage());
												java.sql.SQLException ne_tDBOutput_2 = e_tDBOutput_2.getNextException(),
														sqle_tDBOutput_2 = null;
												String errormessage_tDBOutput_2;
												if (ne_tDBOutput_2 != null) {
													// build new exception to provide the original cause
													sqle_tDBOutput_2 = new java.sql.SQLException(
															e_tDBOutput_2.getMessage() + "\ncaused by: "
																	+ ne_tDBOutput_2.getMessage(),
															ne_tDBOutput_2.getSQLState(), ne_tDBOutput_2.getErrorCode(),
															ne_tDBOutput_2);
													errormessage_tDBOutput_2 = sqle_tDBOutput_2.getMessage();
												} else {
													errormessage_tDBOutput_2 = e_tDBOutput_2.getMessage();
												}

												int countSum_tDBOutput_2 = 0;
												for (int countEach_tDBOutput_2 : e_tDBOutput_2.getUpdateCounts()) {
													countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0
															: countEach_tDBOutput_2);
												}
												rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;

												updatedCount_tDBOutput_2 += countSum_tDBOutput_2;

												System.err.println(errormessage_tDBOutput_2);

											}
										}
										if (rowsToCommitCount_tDBOutput_2 != 0) {

										}
										conn_tDBOutput_2.commit();
										if (rowsToCommitCount_tDBOutput_2 != 0) {

											rowsToCommitCount_tDBOutput_2 = 0;
										}
										commitCounter_tDBOutput_2 = 0;
									}

									tos_count_tDBOutput_2++;

									/**
									 * [tDBOutput_2 main ] stop
									 */

									/**
									 * [tDBOutput_2 process_data_begin ] start
									 */

									currentComponent = "tDBOutput_2";

									/**
									 * [tDBOutput_2 process_data_begin ] stop
									 */

									/**
									 * [tDBOutput_2 process_data_end ] start
									 */

									currentComponent = "tDBOutput_2";

									/**
									 * [tDBOutput_2 process_data_end ] stop
									 */

								} // End of branch "out_update"

								/**
								 * [tMap_2 process_data_end ] start
								 */

								currentComponent = "tMap_2";

								/**
								 * [tMap_2 process_data_end ] stop
								 */

							} // End of branch "row2"

							/**
							 * [tUniqRow_1 process_data_end ] start
							 */

							currentComponent = "tUniqRow_1";

							/**
							 * [tUniqRow_1 process_data_end ] stop
							 */

						} // End of branch "out1"

						/**
						 * [tMap_1 process_data_end ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 process_data_end ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 end ] start
						 */

						currentComponent = "tDBInput_1";

					}
				} finally {
					if (rs_tDBInput_1 != null) {
						rs_tDBInput_1.close();
					}
					if (stmt_tDBInput_1 != null) {
						stmt_tDBInput_1.close();
					}
					if (conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {

						conn_tDBInput_1.commit();

						conn_tDBInput_1.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}

				}
				globalMap.put("tDBInput_1_NB_LINE", nb_line_tDBInput_1);

				ok_Hash.put("tDBInput_1", true);
				end_Hash.put("tDBInput_1", System.currentTimeMillis());

				/**
				 * [tDBInput_1 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row1");
				}

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tUniqRow_1 end ] start
				 */

				currentComponent = "tUniqRow_1";

				globalMap.put("tUniqRow_1_NB_UNIQUES", nb_uniques_tUniqRow_1);
				globalMap.put("tUniqRow_1_NB_DUPLICATES", nb_duplicates_tUniqRow_1);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "out1");
				}

				ok_Hash.put("tUniqRow_1", true);
				end_Hash.put("tUniqRow_1", System.currentTimeMillis());

				/**
				 * [tUniqRow_1 end ] stop
				 */

				/**
				 * [tMap_2 end ] start
				 */

				currentComponent = "tMap_2";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_row3 != null) {
					tHash_Lookup_row3.endGet();
				}
				globalMap.remove("tHash_Lookup_row3");

// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row2");
				}

				ok_Hash.put("tMap_2", true);
				end_Hash.put("tMap_2", System.currentTimeMillis());

				/**
				 * [tMap_2 end ] stop
				 */

				/**
				 * [tDBOutput_1 end ] start
				 */

				currentComponent = "tDBOutput_1";

				try {
					int countSum_tDBOutput_1 = 0;
					if (pstmt_tDBOutput_1 != null && batchSizeCounter_tDBOutput_1 > 0) {

						for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
						}
						rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

					}

					insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

				} catch (java.sql.BatchUpdateException e_tDBOutput_1) {
					globalMap.put("tDBOutput_1_ERROR_MESSAGE", e_tDBOutput_1.getMessage());
					java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(), sqle_tDBOutput_1 = null;
					String errormessage_tDBOutput_1;
					if (ne_tDBOutput_1 != null) {
						// build new exception to provide the original cause
						sqle_tDBOutput_1 = new java.sql.SQLException(
								e_tDBOutput_1.getMessage() + "\ncaused by: " + ne_tDBOutput_1.getMessage(),
								ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(), ne_tDBOutput_1);
						errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
					} else {
						errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
					}

					int countSum_tDBOutput_1 = 0;
					for (int countEach_tDBOutput_1 : e_tDBOutput_1.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

					insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

					System.err.println(errormessage_tDBOutput_1);

				}

				if (pstmt_tDBOutput_1 != null) {

					pstmt_tDBOutput_1.close();
					resourceMap.remove("pstmt_tDBOutput_1");
				}
				resourceMap.put("statementClosed_tDBOutput_1", true);
				if (rowsToCommitCount_tDBOutput_1 != 0) {

				}
				conn_tDBOutput_1.commit();
				if (rowsToCommitCount_tDBOutput_1 != 0) {

					rowsToCommitCount_tDBOutput_1 = 0;
				}
				commitCounter_tDBOutput_1 = 0;

				conn_tDBOutput_1.close();

				resourceMap.put("finish_tDBOutput_1", true);

				nb_line_deleted_tDBOutput_1 = nb_line_deleted_tDBOutput_1 + deletedCount_tDBOutput_1;
				nb_line_update_tDBOutput_1 = nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
				nb_line_inserted_tDBOutput_1 = nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
				nb_line_rejected_tDBOutput_1 = nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;

				globalMap.put("tDBOutput_1_NB_LINE", nb_line_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_UPDATED", nb_line_update_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_DELETED", nb_line_deleted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "out_insert");
				}

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				/**
				 * [tDBOutput_1 end ] stop
				 */

				/**
				 * [tDBOutput_2 end ] start
				 */

				currentComponent = "tDBOutput_2";

				try {
					int countSum_tDBOutput_2 = 0;
					if (pstmt_tDBOutput_2 != null && batchSizeCounter_tDBOutput_2 > 0) {

						for (int countEach_tDBOutput_2 : pstmt_tDBOutput_2.executeBatch()) {
							countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
						}
						rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;

					}

					updatedCount_tDBOutput_2 += countSum_tDBOutput_2;

				} catch (java.sql.BatchUpdateException e_tDBOutput_2) {
					globalMap.put("tDBOutput_2_ERROR_MESSAGE", e_tDBOutput_2.getMessage());
					java.sql.SQLException ne_tDBOutput_2 = e_tDBOutput_2.getNextException(), sqle_tDBOutput_2 = null;
					String errormessage_tDBOutput_2;
					if (ne_tDBOutput_2 != null) {
						// build new exception to provide the original cause
						sqle_tDBOutput_2 = new java.sql.SQLException(
								e_tDBOutput_2.getMessage() + "\ncaused by: " + ne_tDBOutput_2.getMessage(),
								ne_tDBOutput_2.getSQLState(), ne_tDBOutput_2.getErrorCode(), ne_tDBOutput_2);
						errormessage_tDBOutput_2 = sqle_tDBOutput_2.getMessage();
					} else {
						errormessage_tDBOutput_2 = e_tDBOutput_2.getMessage();
					}

					int countSum_tDBOutput_2 = 0;
					for (int countEach_tDBOutput_2 : e_tDBOutput_2.getUpdateCounts()) {
						countSum_tDBOutput_2 += (countEach_tDBOutput_2 < 0 ? 0 : countEach_tDBOutput_2);
					}
					rowsToCommitCount_tDBOutput_2 += countSum_tDBOutput_2;

					updatedCount_tDBOutput_2 += countSum_tDBOutput_2;

					System.err.println(errormessage_tDBOutput_2);

				}

				if (pstmt_tDBOutput_2 != null) {

					pstmt_tDBOutput_2.close();
					resourceMap.remove("pstmt_tDBOutput_2");
				}
				resourceMap.put("statementClosed_tDBOutput_2", true);
				if (rowsToCommitCount_tDBOutput_2 != 0) {

				}
				conn_tDBOutput_2.commit();
				if (rowsToCommitCount_tDBOutput_2 != 0) {

					rowsToCommitCount_tDBOutput_2 = 0;
				}
				commitCounter_tDBOutput_2 = 0;

				conn_tDBOutput_2.close();

				resourceMap.put("finish_tDBOutput_2", true);

				nb_line_deleted_tDBOutput_2 = nb_line_deleted_tDBOutput_2 + deletedCount_tDBOutput_2;
				nb_line_update_tDBOutput_2 = nb_line_update_tDBOutput_2 + updatedCount_tDBOutput_2;
				nb_line_inserted_tDBOutput_2 = nb_line_inserted_tDBOutput_2 + insertedCount_tDBOutput_2;
				nb_line_rejected_tDBOutput_2 = nb_line_rejected_tDBOutput_2 + rejectedCount_tDBOutput_2;

				globalMap.put("tDBOutput_2_NB_LINE", nb_line_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_UPDATED", nb_line_update_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_DELETED", nb_line_deleted_tDBOutput_2);
				globalMap.put("tDBOutput_2_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_2);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "out_update");
				}

				ok_Hash.put("tDBOutput_2", true);
				end_Hash.put("tDBOutput_2", System.currentTimeMillis());

				/**
				 * [tDBOutput_2 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tMap_2"
			globalMap.remove("tHash_Lookup_row3");

			try {

				/**
				 * [tDBInput_1 finally ] start
				 */

				currentComponent = "tDBInput_1";

				/**
				 * [tDBInput_1 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tUniqRow_1 finally ] start
				 */

				currentComponent = "tUniqRow_1";

				/**
				 * [tUniqRow_1 finally ] stop
				 */

				/**
				 * [tMap_2 finally ] start
				 */

				currentComponent = "tMap_2";

				/**
				 * [tMap_2 finally ] stop
				 */

				/**
				 * [tDBOutput_1 finally ] start
				 */

				currentComponent = "tDBOutput_1";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
						if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_1")) != null) {
							pstmtToClose_tDBOutput_1.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_1") == null) {
						java.sql.Connection ctn_tDBOutput_1 = null;
						if ((ctn_tDBOutput_1 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_1")) != null) {
							try {
								ctn_tDBOutput_1.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_1) {
								String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :"
										+ sqlEx_tDBOutput_1.getMessage();
								System.err.println(errorMessage_tDBOutput_1);
							}
						}
					}
				}

				/**
				 * [tDBOutput_1 finally ] stop
				 */

				/**
				 * [tDBOutput_2 finally ] start
				 */

				currentComponent = "tDBOutput_2";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_2") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_2 = null;
						if ((pstmtToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_2")) != null) {
							pstmtToClose_tDBOutput_2.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_2") == null) {
						java.sql.Connection ctn_tDBOutput_2 = null;
						if ((ctn_tDBOutput_2 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_2")) != null) {
							try {
								ctn_tDBOutput_2.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_2) {
								String errorMessage_tDBOutput_2 = "failed to close the connection in tDBOutput_2 :"
										+ sqlEx_tDBOutput_2.getMessage();
								System.err.println(errorMessage_tDBOutput_2);
							}
						}
					}
				}

				/**
				 * [tDBOutput_2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}

	public static class row3Struct implements routines.system.IPersistableComparableLookupRow<row3Struct> {
		final static byte[] commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets = new byte[0];
		static byte[] commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public Integer id_raquette;

		public Integer getId_raquette() {
			return this.id_raquette;
		}

		public String sku;

		public String getSku() {
			return this.sku;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.sku == null) ? 0 : this.sku.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row3Struct other = (row3Struct) obj;

			if (this.sku == null) {
				if (other.sku != null)
					return false;

			} else if (!this.sku.equals(other.sku))

				return false;

			return true;
		}

		public void copyDataTo(row3Struct other) {

			other.id_raquette = this.id_raquette;
			other.sku = this.sku;

		}

		public void copyKeysDataTo(row3Struct other) {

			other.sku = this.sku;

		}

		private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			Integer intReturn;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = unmarshaller.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PADEL_SA_V1_dw_dim_rackets.length) {
					if (length < 1024 && commonByteArray_PADEL_SA_V1_dw_dim_rackets.length == 0) {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[1024];
					} else {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length);
				strReturn = new String(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PADEL_SA_V1_dw_dim_rackets.length) {
					if (length < 1024 && commonByteArray_PADEL_SA_V1_dw_dim_rackets.length == 0) {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[1024];
					} else {
						commonByteArray_PADEL_SA_V1_dw_dim_rackets = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length);
				strReturn = new String(commonByteArray_PADEL_SA_V1_dw_dim_rackets, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets) {

				try {

					int length = 0;

					this.sku = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PADEL_SA_V1_dw_dim_rackets) {

				try {

					int length = 0;

					this.sku = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.sku, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.sku, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.id_raquette = readInteger(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.id_raquette = readInteger(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeInteger(this.id_raquette, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeInteger(this.id_raquette, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id_raquette=" + String.valueOf(id_raquette));
			sb.append(",sku=" + sku);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.sku, other.sku);
			if (returnValue != 0) {
				return returnValue;
			}

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row3Struct row3 = new row3Struct();

				/**
				 * [tAdvancedHash_row3 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row3", false);
				start_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row3";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row3");
				}

				int tos_count_tAdvancedHash_row3 = 0;

				// connection name:row3
				// source node:tDBInput_2 - inputs:(after_tDBInput_1) outputs:(row3,row3) |
				// target node:tAdvancedHash_row3 - inputs:(row3) outputs:()
				// linked node: tMap_2 - inputs:(row2,row3) outputs:(out_insert,out_update)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row3 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row3Struct>getLookup(matchingModeEnum_row3);

				globalMap.put("tHash_Lookup_row3", tHash_Lookup_row3);

				/**
				 * [tAdvancedHash_row3 begin ] stop
				 */

				/**
				 * [tDBInput_2 begin ] start
				 */

				ok_Hash.put("tDBInput_2", false);
				start_Hash.put("tDBInput_2", System.currentTimeMillis());

				currentComponent = "tDBInput_2";

				int tos_count_tDBInput_2 = 0;

				int nb_line_tDBInput_2 = 0;
				java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "org.postgresql.Driver";
				java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = "postgres";

				final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:+JfYtGN6rmuMD2855Zz9We67p/mhUYZna3nWx+u5ynA/N9e+5Q==");

				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;

				String url_tDBInput_2 = "jdbc:postgresql://" + "localhost" + ":" + "5432" + "/" + "padel_DWH";

				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2, dbUser_tDBInput_2,
						dbPwd_tDBInput_2);

				conn_tDBInput_2.setAutoCommit(false);

				java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

				String dbquery_tDBInput_2 = "SELECT id_raquette, sku FROM dw.dim_raquette";

				globalMap.put("tDBInput_2_QUERY", dbquery_tDBInput_2);
				java.sql.ResultSet rs_tDBInput_2 = null;

				try {
					rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
					java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
					int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

					String tmpContent_tDBInput_2 = null;

					while (rs_tDBInput_2.next()) {
						nb_line_tDBInput_2++;

						if (colQtyInRs_tDBInput_2 < 1) {
							row3.id_raquette = null;
						} else {

							row3.id_raquette = rs_tDBInput_2.getInt(1);
							if (rs_tDBInput_2.wasNull()) {
								row3.id_raquette = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 2) {
							row3.sku = null;
						} else {

							row3.sku = routines.system.JDBCUtil.getString(rs_tDBInput_2, 2, false);
						}

						/**
						 * [tDBInput_2 begin ] stop
						 */

						/**
						 * [tDBInput_2 main ] start
						 */

						currentComponent = "tDBInput_2";

						tos_count_tDBInput_2++;

						/**
						 * [tDBInput_2 main ] stop
						 */

						/**
						 * [tDBInput_2 process_data_begin ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row3 main ] start
						 */

						currentComponent = "tAdvancedHash_row3";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row3"

							);
						}

						row3Struct row3_HashRow = new row3Struct();

						row3_HashRow.id_raquette = row3.id_raquette;

						row3_HashRow.sku = row3.sku;

						tHash_Lookup_row3.put(row3_HashRow);

						tos_count_tAdvancedHash_row3++;

						/**
						 * [tAdvancedHash_row3 main ] stop
						 */

						/**
						 * [tAdvancedHash_row3 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row3";

						/**
						 * [tAdvancedHash_row3 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row3 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row3";

						/**
						 * [tAdvancedHash_row3 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 process_data_end ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 end ] start
						 */

						currentComponent = "tDBInput_2";

					}
				} finally {
					if (rs_tDBInput_2 != null) {
						rs_tDBInput_2.close();
					}
					if (stmt_tDBInput_2 != null) {
						stmt_tDBInput_2.close();
					}
					if (conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {

						conn_tDBInput_2.commit();

						conn_tDBInput_2.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}

				}
				globalMap.put("tDBInput_2_NB_LINE", nb_line_tDBInput_2);

				ok_Hash.put("tDBInput_2", true);
				end_Hash.put("tDBInput_2", System.currentTimeMillis());

				/**
				 * [tDBInput_2 end ] stop
				 */

				/**
				 * [tAdvancedHash_row3 end ] start
				 */

				currentComponent = "tAdvancedHash_row3";

				tHash_Lookup_row3.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row3");
				}

				ok_Hash.put("tAdvancedHash_row3", true);
				end_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row3 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_2 finally ] start
				 */

				currentComponent = "tDBInput_2";

				/**
				 * [tDBInput_2 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row3 finally ] start
				 */

				currentComponent = "tAdvancedHash_row3";

				/**
				 * [tAdvancedHash_row3 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final dw_dim_rackets dw_dim_racketsClass = new dw_dim_rackets();

		int exitCode = dw_dim_racketsClass.runJobInTOS(args);

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		if (inOSGi) {
			java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

			if (jobProperties != null && jobProperties.get("context") != null) {
				contextStr = (String) jobProperties.get("context");
			}
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = dw_dim_rackets.class.getClassLoader()
					.getResourceAsStream("padel_sa_v1/dw_dim_rackets_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = dw_dim_rackets.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tDBRow_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBRow_1) {
			globalMap.put("tDBRow_1_SUBPROCESS_STATE", -1);

			e_tDBRow_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : dw_dim_rackets");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 140443 characters generated by Talend Open Studio for Data Integration on the
 * 28 février 2026, 15:36:48 WAT
 ************************************************************************************************/