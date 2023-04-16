from flask import Blueprint, jsonify, request

mitre = Blueprint("mitre", __name__, url_prefix="/mitre")

@mitre.route("/test",methods=['GET'])
def get_mitreTest():
  print('== MITRE ATT&CK Test')
  try:
    data = {'attackTool':'Nmap'}
    Result = { 'code' : 200, 'data' : data }
    return jsonify(Result)

  except Exception as e:
    print(e)
    Result = { 'code' : 500}
    return jsonify(Result)
  

@mitre.route("/techniques", methods=['POST'])
def get_techniques():
  print('== MITRE ATT&CK ==')
  try:
    request_data = request.get_json()
    userIdx = request_data['idx']

    statisticsList = CardRepository.findCardByStatisticsYear(userIdx)
    
    Result = { 'code' : 20000, 'data' : statisticsList }
    return jsonify(Result)

  except Exception as e:
    print(e)
    Result = { 'code' : 50000, 'message' : Message.Letter.noneCard.value }
    return jsonify(Result)
