package app.web.cuongnk.core.controller;

import app.web.cuongnk.core.config.Constants;
import app.web.cuongnk.core.dto.common.PostMethodResponse;
import app.web.cuongnk.core.dto.user.UserDto;
import app.web.cuongnk.core.service.iface.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuongnk
 * @since 25/04/2023
 */
@RestController
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/user")
  public ResponseEntity<?> createUser(HttpServletRequest request, HttpServletResponse response,
      @RequestBody @Valid UserDto userDto) {

    UserDto dto = userService.createUser(userDto);

    return new ResponseEntity<>(
        PostMethodResponse.builder().status(true).message(Constants.SUCCESS_MSG)
            .httpCode(HttpStatus.OK.value()).id(dto.getId())
            .errorCode(HttpStatus.OK.name().toLowerCase()).build(), HttpStatus.OK);
  }

//  @PostMapping("/campaign")
//  public ResponseEntity<?> createNewCampaign(HttpServletRequest request,
//      HttpServletResponse response, @RequestBody @Valid AddCampaignDto campaignDto)
//      throws ProxyAuthenticationException, ResourceNotFoundException, OperationNotImplementException, UserNotFoundException, ForbiddenException {
//
//    authGuard.verifyPermission(request, null, PermissionObjectCode.CAMPAIGN,
//        ServicePermissionCode.CAMPAIGN_ADD);
//    Integer userId = authGuard.getUserId(request);
//    CampaignDto dto = campaignService.addCampaign(campaignDto, 1);
//
//    return new ResponseEntity<>(
//        PostMethodResponse.builder().status(true).message(Constants.SUCCESS_MSG)
//            .httpCode(HttpStatus.OK.value()).id(dto.getId())
//            .errorCode(HttpStatus.OK.name().toLowerCase()).build(), HttpStatus.OK);
//  }

//  @GetMapping(path = "/campaigns")
//  public ResponseEntity<?> getAll(HttpServletRequest request,
//      @RequestParam(name = "programId", required = false, defaultValue = "") Integer programId,
//      @RequestParam(name = "productId", required = false, defaultValue = "") Integer productId,
//      @RequestParam(name = "smsPlanId", required = false, defaultValue = "") Integer smsPlanId,
//      @RequestParam(name = "transferStatus", required = false, defaultValue = "") String transferStatus,
//      @RequestParam(name = "status", required = false, defaultValue = "") StatusEnum status,
//      @RequestParam(name = "recordStatus", required = false, defaultValue = "") StatusRecordEnum recordStatus,
//      @RequestParam(name = "createdTimeFromDate", required = false) Long createdTimeFromDate,
//      @RequestParam(name = "createdTimeToDate", required = false) Long createdTimeToDate,
//      @RequestParam(name = "callApiTimeFromDate", required = false) Long callApiTimeFromDate,
//      @RequestParam(name = "callApiTimeToDate", required = false) Long callApiTimeToDate,
//      @RequestParam(name = "sendSmsTimeFromDate", required = false) Long sendSmsTimeFromDate,
//      @RequestParam(name = "sendSmsTimeToDate", required = false) Long sendSmsTimeToDate,
//      @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
//      @RequestParam(name = "limit", required = false, defaultValue = "10") Integer limit,
//      @RequestParam(name = "search", required = false, defaultValue = "") String search,
//      @RequestParam(name = "sort", required = false, defaultValue = "") String sort)
//      throws ProxyAuthenticationException, OperationNotImplementException, ResourceNotFoundException, ForbiddenException {
//
//    authGuard.verifyPermission(request, null, PermissionObjectCode.CAMPAIGN,
//        ServicePermissionCode.CAMPAIGN_GET_ALL);
//    DataPagingResponse<CampaignDto> campaigns = campaignService.getAllCampaigns(programId,
//        productId, smsPlanId, transferStatus, status, recordStatus, createdTimeFromDate,
//        createdTimeToDate, callApiTimeFromDate, callApiTimeToDate, sendSmsTimeFromDate,
//        sendSmsTimeToDate, page, limit, search, sort);
//
//    return new ResponseEntity<>(
//        GetMethodResponse.builder().status(true).message(Constants.SUCCESS_MSG)
//            .httpCode(HttpStatus.OK.value()).data(campaigns)
//            .errorCode(HttpStatus.OK.name().toLowerCase()).build(), HttpStatus.OK);
//  }
//
//  @GetMapping("/campaign/{id}")
//  public ResponseEntity<?> getCampaignById(HttpServletRequest request, HttpServletResponse response,
//      @PathVariable("id") Integer id)
//      throws ProxyAuthenticationException, IdentifyBlankException, ResourceNotFoundException, ForbiddenException {
//
//    authGuard.verifyPermission(request, null, PermissionObjectCode.CAMPAIGN,
//        ServicePermissionCode.CAMPAIGN_GET_BY_ID);
//    CampaignDetailDto campaignDetailDto = campaignService.getCampaignById(id);
//
//    return new ResponseEntity<>(
//        GetMethodResponse.builder().status(true).message(Constants.SUCCESS_MSG)
//            .httpCode(HttpStatus.OK.value()).data(campaignDetailDto)
//            .errorCode(HttpStatus.OK.name().toLowerCase()).build(), HttpStatus.OK);
//  }
//
//  @PutMapping("/campaign/{id}")
//  public ResponseEntity<?> updateCampaign(HttpServletRequest request, HttpServletResponse response,
//      @PathVariable("id") Integer id, @RequestBody @Valid CampaignUpdateDto campaignUpdateDto)
//      throws ProxyAuthenticationException, IdentifyBlankException, ResourceNotFoundException, DuplicateEntityException, OperationNotImplementException, ForbiddenException {
//
//    authGuard.verifyPermission(request, null, PermissionObjectCode.CAMPAIGN,
//        ServicePermissionCode.CAMPAIGN_UPDATE);
//    campaignUpdateDto.setId(id);
//    Boolean result = campaignService.updateCampaign(campaignUpdateDto);
//
//    return new ResponseEntity<>(
//        PutMethodResponse.builder().status(result).message(Constants.SUCCESS_MSG)
//            .httpCode(HttpStatus.OK.value()).id(id).errorCode(HttpStatus.OK.name().toLowerCase())
//            .build(), HttpStatus.OK);
//  }
//
//  @PutMapping("/campaign/status")
//  public ResponseEntity<?> updateStatusCampaign(HttpServletRequest request,
//      HttpServletResponse response, @RequestBody CampaignUpdateStatusDto campaignUpdateStatusDto)
//      throws ProxyAuthenticationException, IdentifyBlankException, ResourceNotFoundException, ForbiddenException {
//
//    authGuard.verifyPermission(request, null, PermissionObjectCode.CAMPAIGN,
//        ServicePermissionCode.CAMPAIGN_UPDATE_STATUS);
//
//    Boolean result = campaignService.updateStatusListCampaign(campaignUpdateStatusDto);
//
//    return new ResponseEntity<>(
//        PutMethodResponse.builder().status(result).message(Constants.SUCCESS_MSG)
//            .httpCode(HttpStatus.OK.value()).id(campaignUpdateStatusDto.getId())
//            .errorCode(HttpStatus.OK.name().toLowerCase()).build(), HttpStatus.OK);
//  }
//
//  @PutMapping("/campaign/delete")
//  public ResponseEntity<?> deleteCampaign(HttpServletRequest request, HttpServletResponse response,
//      @RequestBody CampaignDeleteDto campaignDeleteDto)
//      throws ProxyAuthenticationException, IdentifyBlankException, ResourceNotFoundException, ForbiddenException {
//
//    authGuard.verifyPermission(request, null, PermissionObjectCode.CAMPAIGN,
//        ServicePermissionCode.CAMPAIGN_DELETE);
//
//    CampaignDeleteResultDto result = campaignService.deleteListCampaign(campaignDeleteDto);
//
//    Map<String, Object> data = new HashMap<>();
//    data.put("idNotDeleted", result.getIdNotDeleted());
//    data.put("deletedCount", result.getDeletedCount());
//    data.put("notDeletedCount", result.getNotDeletedCount());
//    data.put("idDeleted", result.getIdDeleted());
//
//    Map<String, Object> responseData = new HashMap<>();
//    responseData.put("data", data);
//    responseData.put("status", true);
//    responseData.put("message", Constants.SUCCESS_MSG);
//    responseData.put("httpCode", HttpStatus.OK.value());
//    responseData.put("errorCode", HttpStatus.OK.name().toLowerCase());
//
//    return new ResponseEntity<>(responseData, HttpStatus.OK);
//  }

}
