<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bright future - Detail</title>
<link href="<c:url value="/resources/css/result-content.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/site.css" />" rel="stylesheet">
<%@ page import="uit.se06.scholarshipweb.bus.util.Constants"%>
</head>
<body>
	<div class="container">
		<div id='nav-menu'>
			<%@include file="search-box.jsp"%>
			<ul class="nav-menu-ul">
				<li><a class="menu" href="<c:url value="/" />"><span><%=Constants.MENU_HOME%></span></a></li>
				<li><a class="menu" href="<c:url value="filter" />"><span><%=Constants.MENU_FILTER%></span></a></li>
				<li><a class="menu" href='#'><span><%=Constants.MENU_CONTACT%></span></a></li>
			</ul>
		</div>

		<fieldset class="filter-fieldset">
			<h3 style="padding: 0; margin: 0;"><%=Constants.HEAD_DETAIL%></h3>
			<div class="title-detailpage">${result.getName()}</div>

			<div class="detail-part">
				<div class="heading"></div>
				<div class="detail">
					<div class="detail-head"><%=Constants.PROP_RESULT_LINK%>: <span
							class="detail-content">${result.getOriginalLink()}</span>
					</div>
				</div>

			</div>
			<div class="detail-part">
				<div class="heading"><%=Constants.HEAD_DETAIL_GENERAL%></div>
				<div class="detail">
					<div class="detail-head"><%=Constants.HEAD_RESULT_VALUE%>: <span
							class="detail-content">${result.getValue()}</span>
					</div>
				</div>
				<div class="detail">
					<div class="detail-head"><%=Constants.PROP_SCHOLARSHIP_TYPE%>:
						<span class="detail-content">${result.getScholarshipType()}</span>
					</div>
				</div>
				<c:if
					test="${result.getCount() != null && !result.getCount()['empty']}">
					<div class="detail">
						<div class="detail-head"><%=Constants.PROP_RESULT_COUNT%>: <span
								class="detail-content">${result.getCount()}</span>
						</div>
					</div>
				</c:if>
				<div class="detail">
					<div class="detail-head"><%=Constants.HEAD_RESULT_DATE_END%>:
						<span class="detail-content">${result.getDateEndRegister()}</span>
					</div>
				</div>
				<div class="detail">
					<div class="detail-head"><%=Constants.HEAD_RESULT_SPONSOR%>:
						<span class="detail-content">${result.getSponsorNames()}</span>
					</div>
				</div>
				<c:if
					test="${result.getDescription() != null && !result.getDescription()['empty']}">
					<div class="detail">
						<div class="detail-head"><%=Constants.PROP_RESULT_DESCRIPTION%>:
							<span class="detail-content">${result.getDescription()}</span>
						</div>
					</div>
				</c:if>
			</div>
			<div class="detail-part">
				<div class="heading"><%=Constants.HEAD_DETAIL_ACADEMIC_LEVEL%></div>

				<div class="detail">
					<div class="detail-head"><%=Constants.PROP_STUDENT_ACADEMIC_LEVEL_DETAIL%>:
						<span class="detail-content">${result.getStudentAcademicLevelDetail()}</span>
					</div>
				</div>

				<div class="detail">
					<div class="detail-head"><%=Constants.PROP_STUDENT_ACADEMIC_LEVEL_DETAIL%>:
						<span class="detail-content">${result.getScholarshipAcademicLevelDetail()}</span>
					</div>
				</div>

				<div class="detail">
					<div class="detail-head"><%=Constants.PROP_SCHOLARSHIP_MAJOR%>:
						<span class="detail-content">${result.getScholarshipMajors()}</span>
					</div>
				</div>
			</div>

			<div class="detail-part">
				<div class="heading"><%=Constants.HEAD_DETAIL_STUDENT%></div>

				<c:if
					test="${result.getStudentGender() != null && !result.getStudentGender()['empty']}">
					<div class="detail">
						<div class="detail-head"><%=Constants.PROP_GENDER%>: <span
								class="detail-content">${result.getStudentGender()}</span>
						</div>
					</div>
				</c:if>

				<c:if
					test="${result.getStudentCitizenship() != null && !result.getStudentCitizenship()['empty']}">
					<div class="detail">
						<div class="detail-head"><%=Constants.PROP_CITIZENSHIP%>: <span
								class="detail-content">${result.getStudentCitizenship()}</span>
						</div>
					</div>
				</c:if>

				<c:if
					test="${result.getStudentEthnic() != null && !result.getStudentEthnic()['empty']}">
					<div class="detail">
						<div class="detail-head"><%=Constants.PROP_ETHNIC%>: <span
								class="detail-content">${result.getStudentEthnic()}</span>
						</div>
					</div>
				</c:if>

				<c:if
					test="${result.getStudentReligion() != null && !result.getStudentReligion()['empty']}">
					<div class="detail">
						<div class="detail-head"><%=Constants.PROP_RELIGION%>: <span
								class="detail-content">${result.getStudentReligion()}</span>
						</div>
					</div>
				</c:if>

				<c:if
					test="${result.getStudentResidence() != null && !result.getStudentResidence()['empty']}">
					<div class="detail">
						<div class="detail-head"><%=Constants.PROP_RESIDENCE%>: <span
								class="detail-content">${result.getStudentResidence()}</span>
						</div>
					</div>
				</c:if>
				<c:if
					test="${result.getStudentFamilyPolicies() != null && !result.getStudentFamilyPolicies()['empty']}">
					<div class="detail">
						<div class="detail-head"><%=Constants.PROP_FAMILY_POLICY%>:
							<span class="detail-content">${result.getStudentFamilyPolicies()}</span>
						</div>
					</div>
				</c:if>
				<c:if
					test="${result.getStudentDisabilities() != null && !result.getStudentDisabilities()['empty']}">
					<div class="detail">
						<div class="detail-head"><%=Constants.PROP_DISABILITY%>: <span
								class="detail-content">${result.getStudentDisabilities()}</span>
						</div>
					</div>
				</c:if>
				<c:if
					test="${result.getStudentTerminalIllnesses() != null && !result.getStudentTerminalIllnesses()['empty']}">
					<div class="detail">
						<div class="detail-head"><%=Constants.PROP_TERMINAL_ILL%>: <span
								class="detail-content">${result.getStudentTerminalIllnesses()}</span>
						</div>
					</div>
				</c:if>
				<c:if
					test="${result.getStudentTalents() != null && !result.getStudentTalents()['empty']}">
					<div class="detail">
						<div class="detail-head"><%=Constants.PROP_TALENT%>: <span
								class="detail-content">${result.getStudentTalents()}</span>
						</div>
					</div>
				</c:if>
			</div>


			<div class="detail-part">
				<div class="heading"><%=Constants.HEAD_RESULT_SCHOOL%></div>
				<div class="detail">
					<div class="detail-head"><%=Constants.HEAD_RESULT_NAME%>: <span
							class="detail-content">${result.getSchoolName()}</span>
					</div>
				</div>

				<c:if test="${school != null && !school['empty']}">
					<c:if
						test="${school.getAddress() != null && !school.getAddress()['empty']}">
						<div class="detail">
							<div class="detail-head"><%=Constants.HEAD_RESULT_ADDRESS%>:
								<span class="detail-content">${school.getAddress()}</span>
							</div>
						</div>
					</c:if>

					<c:if
						test="${school.getPhone() != null && !school.getPhone()['empty']}">
						<div class="detail">
							<div class="detail-head"><%=Constants.HEAD_RESULT_PHONE%>:
								<span class="detail-content">${school.getPhone()}</span>
							</div>
						</div>
					</c:if>
					<c:if
						test="${school.getWebsite() != null && !school.getWebsite()['empty']}">
						<div class="detail">
							<div class="detail-head"><%=Constants.HEAD_RESULT_WEBSITE%>:
								<span class="detail-content">${school.getWebsite()}</span>
							</div>
						</div>
					</c:if>
					<c:if
						test="${school.getFax() != null && !school.getFax()['empty']}">
						<div class="detail">
							<div class="detail-head"><%=Constants.HEAD_RESULT_FAX%>: <span
									class="detail-content">${school.getFax()}</span>
							</div>
						</div>
					</c:if>

				</c:if>
			</div>

			<div class="detail-part">
				<div class="heading"><%=Constants.HEAD_DETAIL_APPLICATION%></div>
				<div class="detail">
					<div class="detail-head"><%=Constants.PROP_RESULT_FORM_OF_APPLICATION%>:
						<span class="detail-content">${result.getFormOfParticipation()}</span>
					</div>
				</div>

				<c:if
					test="${result.getApplicationDescription() != null && !result.getApplicationDescription()['empty']}">

					<div class="detail">
						<div class="detail-head"><%=Constants.PROP_RESULT_DESCRIPTION_APPLICATION%>:
							<span class="detail-content">${result.getApplicationDescription()}</span>
						</div>
					</div>
				</c:if>

				<c:if
					test="${result.getSupportDescription() != null && !result.getSupportDescription()['empty']}">

					<div class="detail">
						<div class="detail-head"><%=Constants.PROP_RESULT_DESCRIPTION_SUPPORT%>:
							<span class="detail-content">${result.getSupportDescription()}</span>
						</div>
					</div>
				</c:if>

			</div>

		</fieldset>
	</div>
</body>
</html>