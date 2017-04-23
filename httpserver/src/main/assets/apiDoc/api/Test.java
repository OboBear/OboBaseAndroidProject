/**
 * @api {get} /user/:id Request User information
 * @apiVersion 0.2.0
 * @apiName GetUser
 * @apiGroup User
 *
 * @apiParam {Number} id Users unique ID.
 * @apiParam {Integer} appId AppIdIS asdjio qwegh
 * @apiSuccess {String} firstname Firstname of the User.
 * @apiSuccess {String} lastname  Lastname of the User.
 * @apiSuccessExample Success-Response:
 *     HTTP/1.1 404 Not Found
 *     {
 *       "success": "UserNotFound"
 *     }
 * @apiSuccessExample Success-Response2:
 *     HTTP/1.1 404 Not Found
 *     {
 *       "success": "UserNotFound2"
 *     }
 * @apiError UserNotFound The id of the User was not found.
 * @apiErrorExample Error-Response:
 *     HTTP/1.1 404 Not Found
 *     {
 *       "error": "UserNotFound"
 *     }
 * @apiPermission none
 */


